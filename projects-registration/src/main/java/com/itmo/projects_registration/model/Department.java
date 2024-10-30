package com.itmo.projects_registration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Department {

	public Department() {}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long departamentId;
	
	@Column(nullable=false)
	private String departmentName;

	public Long getDepartamentId() {
		return departamentId;
	}

	public void setDepartamentId(Long departamentId) {
		this.departamentId = departamentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="departmentId")
	private List<Manager> managers;
	public List<Manager> getManagers() {
	    return managers;
	}
	public void setManagers(List<Manager> managers) {
	    this.managers = managers;
	}

}
