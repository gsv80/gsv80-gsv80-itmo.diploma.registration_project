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

import com.itmo.projects_registration.model.Place;
import com.itmo.projects_registration.service.PlaceService;

@RestController
public class PlaceController {

	@Autowired
	private PlaceService service;
	
	@GetMapping("/places")
	public List<Place> list(){
		return (List<Place>) service.listAll();
	}
	
	@GetMapping("/places/{id}")
	public ResponseEntity<Place> read(@PathVariable("id") Long id) {
		
		try {
			Place place =  service.get(id);
			return new ResponseEntity<Place>(place , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/places")
	public void create(@RequestBody Place place) {
		service.save(place);
	}
	
	@PutMapping("/places/{id}")
	public ResponseEntity<Place> update(@RequestBody Place place, @PathVariable("id") Long id) {
		try{
			Place existPlace = service.get(id);
			service.save(place);
			return new ResponseEntity<Place>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/places/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
}
