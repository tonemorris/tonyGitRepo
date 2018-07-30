
package com.cigna.loader.event;

import org.springframework.context.ApplicationEvent;

public class StartEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	public StartEvent(final Object source) {
		super(source);
	}
}
