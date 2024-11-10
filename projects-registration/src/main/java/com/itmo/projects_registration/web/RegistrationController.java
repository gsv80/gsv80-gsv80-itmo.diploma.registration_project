package com.itmo.projects_registration.web;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmo.projects_registration.model.Registration;
import com.itmo.projects_registration.service.RegistrationService;

@RestController
@RequestMapping("api/registrations")
public class RegistrationController {

	@Autowired
	private final RegistrationService service;
	
	public RegistrationController(RegistrationService service) {
		this.service = service;
	}
	
	@PostMapping("/search/example")
	public List<Registration> findByExample(@RequestBody Registration registration){
		return service.findRegistrationByExample(registration);
	}

	@GetMapping()
    public List<Registration> listAll() {
		return service.listAll(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Registration> read(@PathVariable("id") Long id) {
		
		try {
			Registration registration =  service.get(id);
			return new ResponseEntity<Registration>(registration , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Registration>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public void create(@RequestBody Registration registration) {
		service.save(registration);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Registration> update(@RequestBody Registration registration, @PathVariable("id") Long id) {
		try{
			Registration existRegistration = service.get(id);
			service.save(registration);
			return new ResponseEntity<Registration>(HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Registration>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
	
	// logic for application  

	@GetMapping("/client")
	public ResponseEntity<Registration> findByClient(@RequestBody Registration registration, @PathVariable("client") String client){
		
		return new ResponseEntity<Registration>(registration , HttpStatus.OK);
		
	}
	
}
