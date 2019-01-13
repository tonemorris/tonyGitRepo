package com.cigna.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.user.dto.UserView;

@Component
public class ProcessorConsumer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@JmsListener(destination = "processor")
    public void batchReceiveMessage(UserView  message) {   	
        jmsTemplate.convertAndSend("sink", message);
			System.out.println("Received by Transformer<" + message + ">");
    }

}
