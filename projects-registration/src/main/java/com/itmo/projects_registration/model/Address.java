package com.itmo.projects_registration.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Address {

	public Address() {}
	public Address(String region, String city, String street, String building, Integer postalCode) {
		super();
		this.region = region;
		this.city = city;
		this.street = street;
		this.building = building;
		this.postalCode = postalCode;
		
	}
	
	private String street, building;
	
	private String region;
	
	private String city;
	
	private Integer postalCode;
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
}
