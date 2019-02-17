package com.cigna.demo.workflow.steps;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cigna.demo.domain.PatientProfile;
import com.cigna.demo.validator.LamdaPatientValidator;

@Component
public class CleansingRulesStep {

	private static final Logger logger = LoggerFactory.getLogger(CleansingRulesStep.class);

	@Autowired
	private LamdaPatientValidator lamdaPatientValidator;

	public List<PatientProfile> runStringCleansingRule(List<PatientProfile> profileList) {
		logger.info("Starting runStringCleansingRule...");
		profileList.stream().forEach(p -> lamdaPatientValidator.validate(p));
		return profileList;

	}
}
