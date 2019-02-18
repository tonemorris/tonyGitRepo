package com.cigna.demo.validator;

import com.cigna.demo.domain.PatientProfile;
import com.cigna.demo.validator.interfaces.PatientValidator;

import static com.cigna.demo.validator.helper.StringValidationHelpers.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LamdaPatientValidator implements PatientValidator {

	@Value("${string.cleansing.special.chars.rules}")
	private String specialChar;

	@Value("${string.cleansing.firstname.required.min.length.rule")
	private int firstnameMin;

	public void validate(PatientProfile patientProfile) {
		notNull.and(between(firstnameMin, 12).and(containSpecialChars(specialChar))).test(patientProfile.getFirstName())
				.throwIfInvalid("firstname for Id: " + patientProfile.getId());
		notNull.and(between(2, 12)).test(patientProfile.getLastName())
				.throwIfInvalid("lastname for Id: " + patientProfile.getId());
		phonebetween(1, 10).test(patientProfile.getPhoneNumber())
				.throwIfInvalid("phoneNumber for Id: " + patientProfile.getId());
	}
}
