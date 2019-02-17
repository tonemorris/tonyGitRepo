package com.cigna.loader.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Work_Proc_Temp_Loader")  
public class WorkProc {
	
	@Id
	@Column(name = "patient_account")
    private String patientAccount;

	public String getPatientAccount() {
		return patientAccount;
	}

	public void setPatientAccount(String patientAccount) {
		this.patientAccount = patientAccount;
	}
    
}
    