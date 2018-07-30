/**
 * 
 */
package com.cigna.loader.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private final static Logger logger = LoggerFactory.getLogger(MainController.class);

	public static final String APPLICATION_NAME = "Autofill";


	@RequestMapping(value = "/trigger/event/", method = RequestMethod.GET)
	public void event() throws Exception {
		logger.info("StartEvent");

	}

}
