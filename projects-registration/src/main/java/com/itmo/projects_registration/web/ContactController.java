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

import com.itmo.projects_registration.model.Contact;
import com.itmo.projects_registration.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService service;
	
	@GetMapping("/contacts")
	public List<Contact> list(){
		return (List<Contact>) service.listAll();
	}
	
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> read(@PathVariable("id") Long id) {
		
		try {
			Contact contact =  service.get(id);
			return new ResponseEntity<Contact>(contact , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/contacts")
	public void create(@RequestBody Contact contact) {
		service.save(contact);
	}
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> update(@RequestBody Contact contact, @PathVariable("id") Long id) {
		try{
			Contact existContact = service.get(id);
			service.save(contact);
			return new ResponseEntity<Contact>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/contacts/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
}
