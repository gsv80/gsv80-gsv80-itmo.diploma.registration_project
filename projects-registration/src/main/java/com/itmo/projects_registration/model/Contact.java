package com.itmo.projects_registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact extends Person{

	
	public Contact() {}

	public Contact(String firstName, String lastName, String position, Company companyId, Long phoneNumOne) {
		// TODO Auto-generated constructor stub
		super(firstName, lastName);
		this.position = position;
		this.phoneNumOne = phoneNumOne;
		this.companyId = companyId;
	}
	
	public Contact(String firstName, String lastName, String position, Company companyId, Long phoneNumOne, Long phoneNumTwo) {
		super(firstName, lastName);
		this.position = position;
		this.phoneNumOne = phoneNumOne;
		this.phoneNumTwo = phoneNumTwo;
		this.companyId = companyId;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long contactId;
	
	private String position;
	
	private Long phoneNumOne;
	private Long phoneNumTwo;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="companyId")
	private Company companyId;

	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

	public Long getPhoneNumOne() {
		return phoneNumOne;
	}

	public void setPhoneNumOne(Long phoneNumOne) {
		this.phoneNumOne = phoneNumOne;
	}

	public Long getPhoneNumTwo() {
		return phoneNumTwo;
	}

	public void setPhoneNumTwo(Long phoneNumTwo) {
		this.phoneNumTwo = phoneNumTwo;
	}
	
}
