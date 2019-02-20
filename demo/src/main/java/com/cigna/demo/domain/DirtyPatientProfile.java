package com.cigna.demo.domain;

public class DirtyPatientProfile {

    private int patient;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String error;
    private String fieldName;
    
    private double price;

    public DirtyPatientProfile() {
    }

    public DirtyPatientProfile(int id, String name, double price, String lastName, String phone) {
        this.patient = id;
        this.firstName = name;
        this.price = price;
        this.lastName = lastName;
        this.phoneNumber = phone;
    }

   

    

    public int getPatient() {
		return patient;
	}

	public void setPatient(int patient) {
		this.patient = patient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
}
