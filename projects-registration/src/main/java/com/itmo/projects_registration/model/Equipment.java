package com.itmo.projects_registration.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Equipment {

	public Equipment(String equipmentType
//			, Set<Registration> registrations
			) {
		super();
		this.equipmentType = equipmentType;
//		this.registrations = registrations;
	}

	public Equipment() {}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long equipmentId;
	
	private String equipmentType;
	
	@ManyToMany
    @JoinTable(
            name = "equipment_registration",
            joinColumns = @JoinColumn(name = "equipmentId"),
            inverseJoinColumns = @JoinColumn(name = "registrationId")
    )
    private Set<Registration> registrations = new HashSet<>();

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}
}
