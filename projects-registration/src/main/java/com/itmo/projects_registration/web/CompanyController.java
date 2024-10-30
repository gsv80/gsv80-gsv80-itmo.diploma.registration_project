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

import com.itmo.projects_registration.model.Company;
import com.itmo.projects_registration.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@GetMapping("/companies")
	public List<Company> list(){
		return (List<Company>) service.listAll();
	}
	
	@GetMapping("/companies/{id}")
	public ResponseEntity<Company> read(@PathVariable("id") Long id) {
		
		try {
			Company company =  service.get(id);
			return new ResponseEntity<Company>(company , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/companies")
	public void create(@RequestBody Company company) {
		service.save(company);
	}
	
	@PutMapping("/companies/{id}")
	public ResponseEntity<Company> update(@RequestBody Company company, @PathVariable("id") Long id) {
		try{
			Company existCompany = service.get(id);
			service.save(company);
			return new ResponseEntity<Company>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/companies/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
}
