package com.itmo.projects_registration.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmo.projects_registration.model.Manager;
import com.itmo.projects_registration.service.ManagerService;

//@PreAuthorize("authenticated")
@RestController
public class ManagerController {

	@Autowired
	private ManagerService service;
	
	@GetMapping("/managers")
	public List<Manager> list(){
		return (List<Manager>) service.listAll();
	}
	
	@GetMapping("/managers/{id}")
	public ResponseEntity<Manager> read(@PathVariable("id") Long id) {
		
		try {
			Manager manager =  service.get(id);
			return new ResponseEntity<Manager>(manager , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/managers")
	public void create(@RequestBody Manager manager) {
		service.save(manager);
	}
	
	@PutMapping("/managers/{id}")
	public ResponseEntity<Manager> update(@RequestBody Manager manager, @PathVariable("id") Long id) {
		try{
			Manager existManager = service.get(id);
			service.save(manager);
			return new ResponseEntity<Manager>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Manager>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/managers/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
}
