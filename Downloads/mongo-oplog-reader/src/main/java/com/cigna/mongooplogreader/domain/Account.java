package com.cigna.mongooplogreader.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	private Long id;
	private String name;
	private Long number;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
}
