package com.cigna.demo.validator;

import static com.cigna.demo.validator.helper.StringValidationHelpers.between;
import static com.cigna.demo.validator.helper.StringValidationHelpers.containSpecialChars;
import static com.cigna.demo.validator.helper.StringValidationHelpers.notNull;
import static com.cigna.demo.validator.helper.StringValidationHelpers.phonebetween;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cigna.demo.domain.DirtyPatientProfile;
import com.cigna.demo.domain.PatientProfile;
import com.cigna.demo.validator.interfaces.PatientValidator;

@Component
public class LamdaPatientValidator implements PatientValidator {

	@Value("${string.cleansing.special.chars.rules}")
	private String[] specialChar;

	@Value("${string.cleansing.firstname.required.min.length.rule}")
	private int firstnameMin;

	@Value("${string.cleansing.gender.default.value.rule}")
	private String genderDefaultValue;
	
	private final List<DirtyPatientProfile>  errorPatientProfile = new ArrayList<>();

	public void validate(final DirtyPatientProfile dirtyPatientProfile) {
		
		 if(!notNull.and(between(firstnameMin, 12).and(containSpecialChars(specialChar)))
				.test(dirtyPatientProfile.getFirstName()).throwIfInvalid("firstname for Id: " + dirtyPatientProfile.getPatient())) {
			 buildErrorPatientProfileList(dirtyPatientProfile, "firstname",ValidationResult.getMesssage());
		 }
		 
		 if(!notNull.and(between(2, 12)).test(dirtyPatientProfile.getLastName())
				.throwIfInvalid("lastname for Id: " + dirtyPatientProfile.getPatient())) {
			 buildErrorPatientProfileList(dirtyPatientProfile, "lastname",ValidationResult.getMesssage()); 
		 }
		 if(!notNull.and(phonebetween(1, 10)).test(dirtyPatientProfile.getPhoneNumber())
				.throwIfInvalid("phoneNumber for Id: " + dirtyPatientProfile.getPatient())) {
			 buildErrorPatientProfileList(dirtyPatientProfile, "phoneNumber",ValidationResult.getMesssage()); 
		 }
		 if(!notNull.and(between(1, 1)).test(dirtyPatientProfile.getGender())
				.throwIfInvalid("gender for Id: " + dirtyPatientProfile.getPatient())) {
			 buildErrorPatientProfileList(dirtyPatientProfile, "gender",ValidationResult.getMesssage()); 
		 }

	}

	private void buildErrorPatientProfileList(final DirtyPatientProfile dirtyPatientProfile, final String fieldName, final String errorMessage) {
		dirtyPatientProfile.setError(errorMessage);
		 dirtyPatientProfile.setFieldName(fieldName+" for Id: " + dirtyPatientProfile.getPatient());
		 errorPatientProfile.add(dirtyPatientProfile);
	}

	public final List<DirtyPatientProfile> getErrorPatientProfile() {
		return errorPatientProfile;
	}
	
	
}
