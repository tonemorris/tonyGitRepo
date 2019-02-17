package com.cigna.demo.validator.helper;

import static java.lang.String.format;

import org.springframework.stereotype.Component;

import com.cigna.demo.validator.SimpleValidation;
import com.cigna.demo.validator.Validation;

@Component
public class StringValidationHelpers {
	
	
	public static Validation<String> notNull = SimpleValidation.from((s) -> s != null, "must not be null.");
	
	public static Validation<String> moreThan(int size){
		return SimpleValidation.from((s) -> s.length() >= size, format("must have more than %s chars.", size));
	}
	
	public static Validation<String> lessThan(int size){
		return SimpleValidation.from((s) -> s.length() <= size, format("must have less than %s chars.", size));
	}
	
	public static Validation<String> equal(int size){
		return SimpleValidation.from((s) -> s.length() <= size, format("must not be more than %s numbers.", size));
	}
	
	public static Validation<String> between(int minSize, int maxSize){
		return moreThan(minSize).and(equal(maxSize));
	}
	
	public static Validation<String> isDigit = SimpleValidation.from((s) -> s.chars().allMatch(Character::isDigit), "must not contain any chars.");

	
	public static Validation<String> phonebetween(int minSize, int maxSize){
		return moreThan(minSize).and(equal(maxSize).and(isDigit));
	}
	
	public static Validation<String> contains(String c){
		return SimpleValidation.from((s) -> s.contains(c), format("must contain %s", c));
	}
	
	public static Validation<String> notcontains(String c){
		return SimpleValidation.from((s) -> s.contains(c), format("must not contain any of these special chars: %s", c));
	}
	
}
