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

import com.itmo.projects_registration.model.Equipment;
import com.itmo.projects_registration.service.EquipmentService;

@RestController
public class EquipmentController {
	
	@Autowired
	private EquipmentService service;
	
	@GetMapping("/equipment")
	public List<Equipment> list(){
		return (List<Equipment>) service.listAll();
	}
	
	@GetMapping("/equipment/{id}")
	public ResponseEntity<Equipment> read(@PathVariable("id") Long id) {
		
		try {
			Equipment equipment =  service.get(id);
			return new ResponseEntity<Equipment>(equipment , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Equipment>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/equipment")
	public void create(@RequestBody Equipment equipment) {
		service.save(equipment);
	}
	
	@PutMapping("/equipment/{id}")
	public ResponseEntity<Equipment> update(@RequestBody Equipment equipment, @PathVariable("id") Long id) {
		try{
			Equipment existEquipment = service.get(id);
			service.save(equipment);
			return new ResponseEntity<Equipment>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Equipment>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/equipment/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
}
