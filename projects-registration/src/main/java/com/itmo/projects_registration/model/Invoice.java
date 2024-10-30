package com.itmo.projects_registration.model;

import java.util.Date;
import java.util.GregorianCalendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice {

	public Invoice() {}
	public Invoice(String invoiceNumber, double invoiceCost, boolean paid, Manager managerId, Registration registration) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.invoiceCost = invoiceCost;
		this.invoiceDate = new GregorianCalendar().getTime();;
		this.paid = paid;
		this.managerId=managerId;
		this.registration = registration;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long invoiceId;
	
	@Column(nullable=false)
	private String invoiceNumber;
	private double invoiceCost;
	
	@Column(nullable=false)
	private Date invoiceDate;
	
	@Column(nullable=false)
	private boolean paid;
	
	public Long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public double getInvoiceCost() {
		return invoiceCost;
	}
	public void setInvoiceCost(double invoiceCost) {
		this.invoiceCost = invoiceCost;
	}

	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="managerId")
	private Manager managerId;

	public Manager getManagerId() {
		return managerId;
	}
	
	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="registration")
	private Registration registration;

	public Registration getId() {
		return registration;
	}
	public void setId(Registration registration) {
		this.registration = registration;
	}
	
}
