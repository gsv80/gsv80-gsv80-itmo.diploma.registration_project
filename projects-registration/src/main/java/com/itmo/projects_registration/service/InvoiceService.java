package com.itmo.projects_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.InvoiceRepository;
import com.itmo.projects_registration.model.Invoice;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	public List<Invoice> listAll(){
		return (List<Invoice>) invoiceRepo.findAll();
	}
	
	public void save(Invoice invoice) {
		invoiceRepo.save(invoice);
	}
	
	public Invoice get(Long id) {
		return invoiceRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		invoiceRepo.deleteById(id);
	}
	
}
