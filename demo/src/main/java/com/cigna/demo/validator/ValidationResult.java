package com.cigna.demo.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationResult {
	private boolean valid;
	private static String messsage;
	
	private static final Logger logger = LoggerFactory.getLogger(ValidationResult.class);	

	
	public static ValidationResult ok(){
		return new ValidationResult(true, null);
	}
	
	public static ValidationResult fail(String message){
		return new ValidationResult(false, message);
	}
	
	private ValidationResult(boolean valid, String messsage) {
		this.valid = valid;
		ValidationResult.messsage = messsage;
	}

	public boolean isvalid() {
		return valid;
	}
	
	public void throwIfInvalid() {
		if(!isvalid()) logger.error(getMesssage());
	}
	
	public boolean throwIfInvalid(String fieldName) {
		if(!isvalid()) {
			logger.error(fieldName + " : " + getMesssage());
		} 
	return isvalid();
	}
	
	
	public static String getMesssage() {
		return messsage;
	}	
}
