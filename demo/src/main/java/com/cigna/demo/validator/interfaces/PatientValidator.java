package com.cigna.demo.validator.interfaces;

import com.cigna.demo.domain.DirtyPatientProfile;

public interface PatientValidator {
	
	void validate(DirtyPatientProfile patientProfile);
	
}


