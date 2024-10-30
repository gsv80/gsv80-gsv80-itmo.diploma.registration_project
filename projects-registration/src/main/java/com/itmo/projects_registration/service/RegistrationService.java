package com.itmo.projects_registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.RegistrationRepository;
import com.itmo.projects_registration.model.Company;
import com.itmo.projects_registration.model.Registration;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	private final List<Registration> registrations = new ArrayList<>();
	
	public List<Registration> listAll(){
		return (List<Registration>) registrationRepo.findAll();
	}
	
	public void save(Registration registration) {
		registrationRepo.save(registration);
	}
	
	public Registration get(Long id) {
		return registrationRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		registrationRepo.deleteById(id);
	}
	
}
