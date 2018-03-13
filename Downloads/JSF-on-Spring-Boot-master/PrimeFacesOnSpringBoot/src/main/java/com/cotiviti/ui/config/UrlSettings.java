package com.cotiviti.ui.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "urls")
public class UrlSettings {
	private String workItemUrl;

	public String getWorkItemUrl() {
		return workItemUrl;
	}

	public void setWorkItemUrl(String workItemUrl) {
		this.workItemUrl = workItemUrl;
	}

	public UrlSettings() {
		super();
		
	}
	
	

}
