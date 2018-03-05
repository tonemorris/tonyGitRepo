package com.cigna.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author anthonymorris
 *
 */
@SpringBootApplication
@EnableAsync
public class CustomerApplication {

	public static void main(String[] args) {
        // close the application context to shut down the custom ExecutorService
        SpringApplication.run(CustomerApplication.class, args);
    }
}
