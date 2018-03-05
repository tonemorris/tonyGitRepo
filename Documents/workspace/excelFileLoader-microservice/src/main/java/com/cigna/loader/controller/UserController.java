
package com.cigna.loader.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cigna.loader.domain.User;
import com.cigna.loader.repository.UserRepository;

@RestController
public class UserController {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	private @Resource(name = "h2Datasource") DataSource h2Datasource;

	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public List<User> getUsers() throws InterruptedException {

		jdbcTemplate = new JdbcTemplate(h2Datasource);
		List<User> users = jdbcTemplate.query("SELECT * FROM CSVREAD('\\users\\anthonymorris\\users-with-header.csv')",
				new BeanPropertyRowMapper<User>(User.class));
	
		System.out.println(users);
		
		userRepository.save(users);

		return users;
	}
}
