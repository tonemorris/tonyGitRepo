/**
 * 
 */
package com.cigna.loader.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

public class BatchJobUtil {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	private LocalDateTime lastStartEventDateTime;

	private String fileName = "/logs/excel.log";

	public LocalDateTime getLastEventTime(String searchEvent ) {

		Optional<String> step1LogEntry = null;

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			step1LogEntry = stream.filter(line -> line.contains(searchEvent)).sorted((x, y) -> -1).findFirst();
			step1LogEntry.ifPresent(value -> {
				String[] lastStep1DateArr = value.split(" ");

				String now = lastStep1DateArr[0] + " " + lastStep1DateArr[1];
				lastStartEventDateTime = LocalDateTime.parse(now, formatter);

			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lastStartEventDateTime;
		
	}
}
