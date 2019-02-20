package com.cigna.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.cigna.demo.domain.DirtyPatientProfile;
import com.cigna.demo.events.StringRulesEvent;

@Component
public class BatchRunner implements CommandLineRunner {

	@Autowired
	private ApplicationEventPublisher mApplicationEventPublisher;
	 

	@Override
	public void run(String... args) throws Exception {
		List<DirtyPatientProfile> dirtyPatientProfile = new ArrayList<>();

		for (int i = 0; i < 1; i++) {
			dirtyPatientProfile.add(new DirtyPatientProfile(1, "Audi", 52642, "Morris", "61023594ab"));
			dirtyPatientProfile.add(new DirtyPatientProfile(2, "Mercedes#", 57127, "Morris@", "61023594ab"));
			dirtyPatientProfile.add(new DirtyPatientProfile(3, "Skoda|", 9000, null, null));
			dirtyPatientProfile.add(new DirtyPatientProfile(4, "Volvo@", 29000, "Morris", null));

		}
		
		mApplicationEventPublisher.publishEvent(new StringRulesEvent(dirtyPatientProfile,"stringCleansingRule"));
	
	}

}
