package com.cigna.demo.validator.interfaces;

import com.cigna.demo.validator.ValidationResult;

@FunctionalInterface
public interface Validation<K> {

	ValidationResult test(K param);

	default Validation<K> and(Validation<K> other) {
		return (param) -> {
			ValidationResult firstResult = this.test(param);
			return !firstResult.isvalid() ? firstResult : other.test(param);
		};
	}

	default Validation<K> or(Validation<K> other) {
		return (param) -> {
			ValidationResult firstResult = this.test(param);
			return firstResult.isvalid() ? firstResult : other.test(param);
		};
	}

}
