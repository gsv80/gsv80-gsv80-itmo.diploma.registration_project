package com.itmo.projects_registration.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	
	public Person() {}
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	protected String firstName;
	protected String lastName;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
