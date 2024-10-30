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

import com.itmo.projects_registration.model.Department;
import com.itmo.projects_registration.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping("/departments")
	public List<Department> list(){
		return (List<Department>) service.listAll();
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> read(@PathVariable("id") Long id) {
		
		try {
			Department department =  service.get(id);
			return new ResponseEntity<Department>(department , HttpStatus.OK);
		} 
		catch (NoSuchElementException ex) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/departments")
	public void create(@RequestBody Department department) {
		service.save(department);
	}
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> update(@RequestBody Department department, @PathVariable("id") Long id) {
		try{
			Department existDepartment = service.get(id);
			service.save(department);
			return new ResponseEntity<Department>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/departments/{id}")
	public void delete( @PathVariable("id") Long id) {
		service.delete(id);		
	}
}
