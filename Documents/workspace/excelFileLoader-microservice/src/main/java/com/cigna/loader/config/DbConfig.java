package com.cigna.loader.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DbConfig {
	
	@Primary
	@Bean(name = "h2Datasource")
	  @ConfigurationProperties(prefix="h2.datasource")
	  public DataSource h2DataSource() {
	    return DataSourceBuilder.create().build();
	  }
	
}
