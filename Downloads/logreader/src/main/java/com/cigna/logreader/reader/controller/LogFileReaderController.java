package com.cigna.logreader.reader.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogFileReaderController {

	@Value("${log.file.localtion}")
	private String logFileLocation;
	
	@RequestMapping("/log")
	public List<String> getLogFile() throws IOException {
		String fileName = logFileLocation+ "app.log";
		
		
		
		long lineCount = Files.lines(Paths.get(fileName)).count();
		
		// read file into stream
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			return stream.collect(Collectors.toList());
		}
	}
	
	@RequestMapping("/logs")
	public List<String> getLogFiles() throws IOException {
		String fileName = logFileLocation+ "app.log";
        Path source = Paths.get("/logs/myapp/");

        final String dir = "/logs/myapp/";
        final String pattern = ".log";
        final File file = Paths.get(dir).toFile();
        
        return Stream.of(file.list((pFile, pString) ->  pString.endsWith(pattern)))
                .collect(Collectors.toList());
	}

}
