
package com.cigna.mongodemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoAppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MongoAppRunner.class);

	@Autowired
	private EventListener eventListener;

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("Start listener...");
		eventListener.start();	
	}
}