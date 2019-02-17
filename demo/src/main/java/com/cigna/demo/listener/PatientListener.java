package com.cigna.demo.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cigna.demo.CleansingRulesStep;
import com.cigna.demo.PatientProfile;
import com.cigna.demo.events.StringRulesEvent;

@Component
public class PatientListener {
	
	@Autowired
	private CleansingRulesStep cleansingRuleStep;
	
	@SuppressWarnings("unchecked")
	@EventListener(condition = "#event.rule == 'stringCleansingRule'")
    public void handleStringRules (StringRulesEvent event) {
        System.out.print("context StringRulesEvent event fired: ");
        System.out.println(event);
		cleansingRuleStep.runStringCleansingRule((List<PatientProfile>) event.getSource());

    }
}
