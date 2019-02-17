package com.cigna.sink;

import java.io.File;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.user.dto.UserView;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SikConsumer {
	private ObjectMapper objectMapper;
	
	@JmsListener(destination = "sink")
    public void batchReceiveMessage(UserView message) throws Exception {   
		objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("user.json"), message);
			System.out.println("Received by Sink" + message + ">");
    }

}
