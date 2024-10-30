package com.itmo.projects_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.ManagerRepository;
import com.itmo.projects_registration.model.Manager;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepo;
	
	public List<Manager> listAll(){
		return (List<Manager>) managerRepo.findAll();
	}
	
	public void save(Manager manager) {
		managerRepo.save(manager);
	}
	
	public Manager get(Long id) {
		return managerRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		managerRepo.deleteById(id);
	}
	
	
}
