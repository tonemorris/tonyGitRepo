/**
 * 
 */
package com.cigna.customer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cigna.customer.domain.Cache;
import com.cigna.customer.domain.Order;
import com.cigna.customer.domain.User;

/**
 * @author anthonymorris
 *
 */
@Service
public class CustomerService {
	private final RestTemplate restTemplate;
	
	public CustomerService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

	/**
	 * @param id
	 * @return
	 * @throws InterruptedException 
	 */
	@Async
	public CompletableFuture<User> getOrders(String user) throws InterruptedException {
	        String url = String.format("https://api.github.com/users/%s", user);
	        User results = restTemplate.getForObject(url, User.class);
	        return CompletableFuture.completedFuture(results);
	}

	/**
	 * @param string
	 * @return
	 * @throws InterruptedException 
	 */
	@Async
	public CompletableFuture<Boolean> getConfirmation(String id) throws InterruptedException {
		return CompletableFuture.completedFuture(Boolean.TRUE);
	}

	/**
	 * @param string
	 * @return
	 * @throws InterruptedException 
	 */
	@Async
	public CompletableFuture<Cache> saveRequest(String string) throws InterruptedException {
		Cache cache = new Cache();
		return CompletableFuture.completedFuture(cache);
	}

}
