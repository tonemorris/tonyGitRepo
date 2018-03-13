package com.tivo.ui.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tivo.ui.domain.Book;
import com.tivo.ui.domain.Source;
import com.tivo.ui.service.SourceService;


@RestController
public class SourceController {
	private final SourceService sourceService;
	
	private final static Logger logger = LoggerFactory.getLogger(SourceController.class);
	
	@Autowired
	public SourceController(final SourceService sourceService) {
		this.sourceService = sourceService;
	}

	@RequestMapping("/source")
    public List<Source>findAll() {
		logger.info("inside findAll");
        return sourceService.findAll();
    }
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value="/source")
    public void saveSource(@RequestBody Source source) {
		logger.info("inside saveSource");
		 sourceService.save(source);
     }
	
	
}
