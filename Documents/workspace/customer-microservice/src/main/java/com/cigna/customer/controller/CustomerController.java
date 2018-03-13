
package com.cigna.customer.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cigna.customer.domain.Cache;
import com.cigna.customer.domain.Order;
import com.cigna.customer.domain.User;
import com.cigna.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/order/{id}")
	public User getOrders(@PathVariable("id") String id) throws InterruptedException, Exception {

		// Kick of multiple, asynchronous lookups
		CompletableFuture<User> orders = customerService.getOrders(id);
		CompletableFuture<Boolean> confirmation = customerService.getConfirmation("confirmation");
		CompletableFuture<Cache> resp = customerService.saveRequest("response");

		// Wait until they are all done
        CompletableFuture.allOf(orders,confirmation,resp).join();
        
		return orders.get();
	}
}
