package com.cigna.demo.validator;

import java.util.function.Predicate;

import com.cigna.demo.validator.interfaces.Validation;

public class SimpleValidation<K> implements Validation<K> {

	private Predicate<K> predicate;
	private String onErrorMessage;
	
	public static <K> SimpleValidation<K> from(Predicate<K> predicate, String onErrorMessage) {
		 return new SimpleValidation<K>(predicate, onErrorMessage);
	}
	
	private SimpleValidation(Predicate<K> predicate, String onErrorMessage) {
		this.predicate = predicate;
		this.onErrorMessage = onErrorMessage;
	}
	
	@Override
	public ValidationResult test(K param) {
		return predicate.test(param) ? ValidationResult.ok() : ValidationResult.fail(onErrorMessage);
	}

}
