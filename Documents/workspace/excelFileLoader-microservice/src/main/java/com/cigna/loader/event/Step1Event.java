
package com.cigna.loader.event;

import org.springframework.context.ApplicationEvent;

public class Step1Event extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	public Step1Event(final Object source) {
		super(source);
	}
}
