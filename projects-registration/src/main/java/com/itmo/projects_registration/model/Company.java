package com.itmo.projects_registration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Company {

	public Company() {}
	public Company( String companyName, String propertyForm, Long inn, String type) {
		super();
		this.companyName = companyName;
		this.propertyForm = propertyForm;
		this.inn = inn;
		this.type = type;
		
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long companyId;
	
	private String companyName;
	private String propertyForm;
	private Long inn;
	private String type;
	
	public Long getInn() {
		return inn;
	}
	public void setInn(Long inn) {
		this.inn = inn;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPropertyForm() {
		return propertyForm;
	}
	public void setPropertyForm(String propertyForm) {
		this.propertyForm = propertyForm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="companyId")
	private List<Place> places;

	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="companyId")
	private List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
