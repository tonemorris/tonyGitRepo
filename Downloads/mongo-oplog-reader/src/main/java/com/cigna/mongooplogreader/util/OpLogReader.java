package com.cigna.mongooplogreader.util;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.bson.BsonTimestamp;
import org.bson.Document;
import org.joda.time.DateTime;

import com.cigna.mongooplogreader.domain.OplogLine;
import com.mongodb.BasicDBObject;
import com.mongodb.CursorType;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class OpLogReader implements Runnable {

	private static final Logger log = Logger.getLogger(OpLogReader.class);
	private final BlockingQueue<OplogLine> queue;
	private MongoClient mongoClient;

	public OpLogReader(MongoClient mongoClient, BlockingQueue<OplogLine> queue) {
		this.mongoClient = mongoClient;
		this.queue = queue;
	}

	@Override
	public void run() {
		mongoClient = new MongoClient("localhost");
		MongoDatabase local = mongoClient.getDatabase("local");
		MongoCollection<Document> oplog = local.getCollection("oplog.$main");

		Document last = null;
		{
			FindIterable<Document> lastDoc = oplog.find().sort(new BasicDBObject("$natural", -1)).limit(1);
			MongoCursor<Document> cursor = lastDoc.iterator();

			if (!cursor.hasNext()) {
				log.fatal("no oplog configured for this connection.  Please restart mongo with the --master option.");
				return;
			}

			last = cursor.next();
		}

		BsonTimestamp ts = (BsonTimestamp) last.get("ts");
		log.info("starting point: " + new Date(ts.getTime() * 1000L));

		while (true) {
			log.info("ts: " + new Date(ts.getTime() * 1000L));
			FindIterable<Document> oplogDoc = oplog.find(new BasicDBObject("ts", new BasicDBObject("$gt", ts)));
			final MongoCursor<Document> cursor = oplogDoc.cursorType(CursorType.TailableAwait).iterator();
			ts = insertOplogInQueue(cursor, ts);
		}
	}

	protected BsonTimestamp insertOplogInQueue(MongoCursor<Document> cursor, BsonTimestamp ts) {

		while (cursor.hasNext()) {
			Document x = (Document) cursor.next();
			ts = (BsonTimestamp) x.get("ts");
			OplogLine line = parseLogLine(ts, x);
			if (log.isDebugEnabled()) {
				log.debug(line);
			}
			try {
				if (!queue.offer(line, 10, TimeUnit.SECONDS)) {
					log.error("Failed to insert oplog into queue.  Queue size: [" + queue.size()
							+ "] while trying to insert " + line);
				}
			} catch (InterruptedException e) {
				log.info("oplog offer was interrupted.  exiting oplog reader.", e);
			}
		}
		return ts;
	}

	protected OplogLine parseLogLine(BsonTimestamp ts, Document x) {
		DateTime timestamp = new DateTime(ts.getTime() * 1000l);
		MongoOplogOperation operation = MongoOplogOperation.find((String) x.get("op"));
		String nameSpace = (String) x.get("ns");
		Document data = (Document) x.get("o");
		OplogLine line = new OplogLine(operation, timestamp, nameSpace, data.toString(), data);
		return line;
	}
}
