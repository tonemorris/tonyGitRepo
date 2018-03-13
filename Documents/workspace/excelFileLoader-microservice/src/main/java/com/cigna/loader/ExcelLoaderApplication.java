package com.cigna.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cigna.loader.service.WatcherService;

/**
 * @author anthonymorris
 *
 */
@SpringBootApplication
public class ExcelLoaderApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelLoaderApplication.class);

    @Autowired
    public WatcherService watcherService;
    
	public static void main(String[] args) {
        SpringApplication.run(ExcelLoaderApplication.class, args);
    }

	
	@Override
    public void run(String... strings) throws Exception {
        LOGGER.info("I'm running !");

        new Thread(watcherService, "watcher-service").start();
    }
}
