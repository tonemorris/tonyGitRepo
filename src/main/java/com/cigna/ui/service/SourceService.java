package com.tivo.ui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tivo.ui.domain.Source;
import com.tivo.ui.repository.SourceRepository;

@Service
public class SourceService {

	@Autowired
	private SourceRepository sourceRepository;
	
	public void save(Source source) {
		sourceRepository.save(source);
	}

	public List<Source> findAll() {
		return (List<Source>) sourceRepository.findAll();
	}


}
