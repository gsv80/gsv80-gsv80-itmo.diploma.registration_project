package com.itmo.projects_registration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Manager extends Person {
	

	public Manager() {
//		super();
	}
	
	public Manager(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public Manager(String firstName, String lastName, RoleEnum role, Department departmentId, String username, String password) {
		super(firstName, lastName);
		this.username = username;
		this.password = password;
		this.role = role;
		this.departmentId = departmentId;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	private Long managerId;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	public RoleEnum getRole() {
		return role;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="departmentId")
	private Department departmentId;

	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="managerId")
	private List<Invoice> invoices;
	
	public List<Invoice> getInvoices() {
	    return invoices;
	}
	public void setInvoices(List<Invoice> invoices) {
	    this.invoices = invoices;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
