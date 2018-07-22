/**
 * 
 */
package com.cigna.eventlistenerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

   
	public static final String APPLICATION_NAME = "Autofill";


	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/user/{name}/admin/{role}", method = RequestMethod.GET)
    public void userLogin(@PathVariable("name") String name, @PathVariable("role") boolean isAdmin){
        User user = new User();
        user.setUsername(name);
        user.setAdmin(isAdmin);
        user.setStatus("ACTIVE");

        applicationEventPublisher.publishEvent(new UserEvent(this));
    }
}