package com.cigna.mongooplogreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cigna.mongooplogreader.domain.Account;
import com.cigna.mongooplogreader.jms.KafkaProducer;
import com.cigna.mongooplogreader.jms.MessageStorage;
import com.cigna.mongooplogreader.service.MongoOplogReaderService;

/**
 * @author anthonymorris
 *
 */
@RestController
@RequestMapping(value="/mysql/kafka")
public class MongoOplogReaderController {

	private final MongoOplogReaderService mongoOplogReaderService;
	
	@Autowired
	KafkaProducer producer;
	
	@Autowired
	MessageStorage storage;
	
	@Autowired
	public MongoOplogReaderController(final MongoOplogReaderService mongoOplogReaderService) {
		this.mongoOplogReaderService = mongoOplogReaderService;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/data")
	public void copyDataToMysql(@RequestBody final Account account) {
		
	}
	
	@GetMapping(value="/producer")
	public String producer(@RequestParam("data")String data){
		producer.send(data);
		
		return "Done";
	}
	
	@GetMapping(value="/consumer")
	public String getAllRecievedMessage(){
		String messages = storage.toString();
		storage.clear();
		
		return messages;
	}
}
