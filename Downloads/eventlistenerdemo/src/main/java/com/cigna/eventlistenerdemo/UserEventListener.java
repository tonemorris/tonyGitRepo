/**
 * 
 */
package com.cigna.eventlistenerdemo;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener implements ApplicationListener<UserEvent> {

    @Async
	@Override
	public void onApplicationEvent(UserEvent arg0) {
		System.out.println(arg0);
		
	}

    
}