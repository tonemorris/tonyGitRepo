package com.cigna.loader.service;

import java.nio.file.WatchEvent;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cigna.loader.domain.WorkProc;
import com.cigna.loader.repository.WorkProcRepository;

/**
 * @author anthonymorris
 *
 */
@Service
public class DbLoaderService {

	@Autowired
	private WorkProcRepository workProcRepository;
	private @Resource(name = "h2Datasource") DataSource h2Datasource;
	private JdbcTemplate jdbcTemplate;

	/**
	 * @param event
	 */
	public void fileUpload(WatchEvent<?> event) {
		jdbcTemplate = new JdbcTemplate(h2Datasource);
		List<WorkProc> workProcList = jdbcTemplate.query("SELECT * FROM CSVREAD('\\users\\anthonymorris\\" +event.context()+ "')",
				new BeanPropertyRowMapper<WorkProc>(WorkProc.class));
	
		System.out.println(workProcList);
		
		workProcRepository.save(workProcList);

	}

}
