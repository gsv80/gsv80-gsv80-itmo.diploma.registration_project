package com.itmo.projects_registration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Place extends Address {

	public Place() {}
	
	public Place(String region, String city, String street, String building, Integer postalCode, String placeName, Company companyId) {
		super(region, city, street, building, postalCode);
		// TODO Auto-generated constructor stub
		this.placeName = placeName;
		this.companyId = companyId;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long placeId;
	
	private String placeName;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="companyId")
	private Company companyId;

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="place")
	private List<Registration> registrations;

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	
}
