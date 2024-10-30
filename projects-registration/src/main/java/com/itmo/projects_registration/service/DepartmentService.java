package com.itmo.projects_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.DepartmentRepository;
import com.itmo.projects_registration.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository depRepo;

	public List<Department> listAll(){
		return (List<Department>) depRepo.findAll();
	}
	
	public void save(Department department) {
		depRepo.save(department);
	}
	
	public Department get(Long id) {
		return depRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		depRepo.deleteById(id);
	}
	
}
