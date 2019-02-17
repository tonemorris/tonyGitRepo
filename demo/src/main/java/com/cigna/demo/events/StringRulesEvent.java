package com.cigna.demo.events;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.cigna.demo.PatientProfile;

public class StringRulesEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	private String rule;

	public StringRulesEvent(List<PatientProfile> inSource, String rule) {
		super(inSource);
		this.rule = rule;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}
}
