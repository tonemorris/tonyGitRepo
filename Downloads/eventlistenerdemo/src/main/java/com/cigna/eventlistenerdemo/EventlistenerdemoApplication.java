package com.cigna.eventlistenerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventlistenerdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventlistenerdemoApplication.class, args);
	}
}


