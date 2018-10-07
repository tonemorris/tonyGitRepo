package com.cigna.logreader.reader;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogreaderApplication implements CommandLineRunner {
	
	@Autowired
	private BatchExecutionRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LogreaderApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		Batch batch = repository.findTopByOrderByJobIdDesc();
		
		try {
			batch.setStatus("Finish");
			batch.setEndTime(new Date());
			repository.save(batch);
		} catch (Exception e) {
			repository.save(new Batch(1l, new Date(),new Date(),null,"Start"));

		}
		
	}
}
