
package com.cigna.loader.listener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cigna.loader.event.StartEvent;
import com.cigna.loader.utils.BatchJobUtil;

@Component
public class LogEventListener {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	private BatchJobUtil batchJobUtil;
	private String fileName = "/logs/excel.log";
	private LocalDateTime lastStartEventDateTime;
	private LocalDateTime lastStep1EventDateTime;
	private LocalDateTime lastEventDateTime;

	@PostConstruct
	private void init() {
		batchJobUtil = new BatchJobUtil();
		lastStartEventDateTime = batchJobUtil.getLastEventTime("StartEvent");
		lastStep1EventDateTime = batchJobUtil.getLastEventTime("Step1Event");
	}

	@EventListener
	public void handleStartEvents(final StartEvent startEvent) {
		if (lastStartEventDateTime == null) {
			lastStartEventDateTime = LocalDateTime.now();
		}

		lastStartEventDateTime = logEvent("StartEvent", lastStartEventDateTime);
	}

	@EventListener
	public void handleStep1Events(final StartEvent startEvent) {
		if (lastStep1EventDateTime == null) {
			lastStep1EventDateTime = LocalDateTime.now();
		}

		lastStep1EventDateTime = logEvent("Step1Event", lastStep1EventDateTime);
	}

	private LocalDateTime logEvent(String logEvent, LocalDateTime eventDateTime) {

		Optional<String> startLog = null;
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			startLog = stream.filter(line -> line.contains(logEvent)).sorted((x, y) -> -1).findFirst();
			startLog.ifPresent(value -> {
				String[] lastStartDate = value.split(" ");

				String logDateTime = lastStartDate[0] + " " + lastStartDate[1];
				LocalDateTime formatDateTime = LocalDateTime.parse(logDateTime, formatter);

				if (formatDateTime.isAfter(eventDateTime)) {
					System.out.println(logEvent + " event is invoked");
					lastEventDateTime = formatDateTime;
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lastEventDateTime;
	}
}
