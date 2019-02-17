/**
 * 
 */
package com.cigna.eventlistenerdemo;

import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;

@Async
public class UserEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserEvent(Object source) {
        super(source);
        
    }

    
}