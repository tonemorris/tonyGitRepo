package com.cigna.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.cigna.demo.domain.PatientProfile;
import com.cigna.demo.events.StringRulesEvent;

@Component
public class BatchRunner implements CommandLineRunner {

	@Autowired
	private ApplicationEventPublisher mApplicationEventPublisher;
	 

	@Override
	public void run(String... args) throws Exception {
		List<PatientProfile> patientProfiles = new ArrayList<>();

		for (int i = 0; i < 1; i++) {
			patientProfiles.add(new PatientProfile(1, "Audi#!", 52642, "Morrisbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb|", "61023594ab"));
			patientProfiles.add(new PatientProfile(2, "Mercedes#", 57127, "Morris@", "61023594ab"));
			patientProfiles.add(new PatientProfile(3, "Skoda|", 9000, null, "61023594bc"));
			patientProfiles.add(new PatientProfile(4, "Volvo@", 29000, "Morris", "6102359486"));

		}
		
		mApplicationEventPublisher.publishEvent(new StringRulesEvent(patientProfiles,"stringCleansingRule"));
	
	}

}
