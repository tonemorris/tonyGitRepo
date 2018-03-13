/**
 * 
 */
package com.cigna.mongooplogreader;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cigna.mongooplogreader.domain.Account;
import com.cigna.mongooplogreader.domain.OplogLine;
import com.cigna.mongooplogreader.service.MongoOplogReaderService;
import com.cigna.mongooplogreader.util.OpLogReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * @author anthonymorris
 *
 */
@Component
public class OpLogReaderAppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(OpLogReaderAppRunner.class);
	
	@Autowired
	private MongoOplogReaderService mongoOplogReaderService;

	@Override
	public void run(String... arg0) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			MongoClient mongo = new MongoClient("localhost");
			BlockingQueue<OplogLine> queue = new LinkedBlockingQueue<OplogLine>();
			OpLogReader reader = new OpLogReader(mongo, queue);
			ExecutorService executor = Executors.newSingleThreadExecutor();
			executor.execute(reader);
			executor.shutdown();
			
			try {
				while (!executor.isTerminated()) {
					OplogLine line = queue.poll(30, TimeUnit.SECONDS);
					Account account = null;
					Document data = null;
					
					switch(line.getOperation().name()) {
					   case "Update" :
					      System.out.println("Execute update statement: " + line.getOperation().name());
					      data = line.getDocData();
					      account = new Account();
					      account.setId((Long) data.get("_id"));
					      account.setName((String) data.get("name"));
					      account.setNumber((Long) data.get("number"));
					      mongoOplogReaderService.copy(account);
					      break; 
					   
					   case "Delete" :
						      System.out.println("Execute Delete statement: "+ line.getOperation().name());
					      break;
					      
					   case "Insert" :
						      System.out.println("Execute Insert statement: "+ line.getOperation().name());
						      data = line.getDocData();
						      account = new Account();
						      account.setId((Long) data.get("_id"));
						      account.setName((String) data.get("name"));
						      account.setNumber((Long) data.get("number"));
						      mongoOplogReaderService.copy(account);
						  break; 
					   
					 default : 
					      System.out.println("Execute default statement: "+ line.getOperation().name());
					}		
   
					logger.info("Line info: " + line);
				}
			} catch (InterruptedException e) {
				logger.info("time to go.");
				executor.shutdownNow();
			}
		} catch (MongoException e) {
			logger.error(e.getMessage(),e);
		}
	}
}
