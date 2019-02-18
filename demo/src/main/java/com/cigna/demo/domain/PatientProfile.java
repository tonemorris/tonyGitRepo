package com.cigna.demo.domain;

public class PatientProfile {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;


    private double price;

    public PatientProfile() {
    }

    public PatientProfile(int id, String name, double price, String lastName, String phone) {
        this.id = id;
        this.firstName = name;
        this.price = price;
        this.lastName = lastName;
        this.phoneNumber = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
	
	
}
