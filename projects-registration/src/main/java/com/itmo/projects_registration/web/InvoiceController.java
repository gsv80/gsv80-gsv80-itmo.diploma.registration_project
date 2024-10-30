package com.itmo.projects_registration.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmo.projects_registration.model.Invoice;
import com.itmo.projects_registration.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceService service;
	
	@GetMapping("/invoices")
	public List<Invoice> list(){
		return (List<Invoice>) service.listAll();
	}
	
	@GetMapping("/invoices/{id}")
	public ResponseEntity<Invoice> read(@PathVariable("id") Long id) {
		
		try {
			Invoice invoice =  service.get(id);
			return new ResponseEntity<Invoice>(invoice , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/invoices")
	public void create(@RequestBody Invoice invoice) {
		service.save(invoice);
	}
	
	@PutMapping("/invoices/{id}")
	public ResponseEntity<Invoice> update(@RequestBody Invoice invoice, @PathVariable("id") Long id) {
		try{
			Invoice existInvoice = service.get(id);
			service.save(invoice);
			return new ResponseEntity<Invoice>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/invoices/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
}
