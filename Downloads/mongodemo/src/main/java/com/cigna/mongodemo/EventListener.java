
package com.cigna.mongodemo;

import static java.util.Arrays.asList;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.FullDocument;

@Component
public class EventListener {

	private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

	@Autowired
	private MongoClient mongoClient;

	public void start() {

		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> eventCollection = database.getCollection("accounts");

		Block<ChangeStreamDocument<Document>> printBlock = new Block<ChangeStreamDocument<Document>>() {
			public void apply(final ChangeStreamDocument<Document> changeStreamDocument) {
				logger.info(changeStreamDocument.getOperationType() +" "+changeStreamDocument.getFullDocument().toJson());
			}
		};

		eventCollection
				.watch(asList(
						Aggregates.match(Filters.in ("operationType", asList("insert", "update", "replace", "delete")))))
				.fullDocument(FullDocument.UPDATE_LOOKUP).forEach(printBlock);
	}
}