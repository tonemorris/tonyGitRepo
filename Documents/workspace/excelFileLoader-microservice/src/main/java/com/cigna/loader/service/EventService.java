package com.cigna.loader.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.cigna.loader.event.StartEvent;
import com.cigna.loader.event.Step1Event;
import com.cigna.loader.utils.BatchJobUtil;

@Service
public class EventService {

	@Autowired
	private ApplicationEventPublisher mApplicationEventPublisher;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	private BatchJobUtil batchJobUtil;
	private String fileName = "/logs/excel.log";

	private LocalDateTime lastStartEventDateTime;

	private LocalDateTime lastStep1EventDateTime;

	@PostConstruct
	private void init() {
		batchJobUtil = new BatchJobUtil();
		lastStartEventDateTime = batchJobUtil.getLastEventTime("StartEvent");
		lastStep1EventDateTime = batchJobUtil.getLastEventTime("Step1Event");
	}

	/**
	 * @param event
	 */
	public void invoke(WatchEvent<?> event) {

		

	}

	

	

}
