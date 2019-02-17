package com.cigna.source;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.UserView;

@RestController
@RequestMapping("source")
public class PutMsgOnQueueController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@ResponseBody
	@RequestMapping("/balkload")
	public int putOnBatchQueue(@RequestBody UserView user) {
		System.out.println("Sending an email message.");
		jmsTemplate.convertAndSend("processor", user);
		return HttpStatus.SC_OK;
	}

}
