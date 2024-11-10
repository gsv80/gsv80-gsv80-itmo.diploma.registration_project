package com.itmo.projects_registration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.RegistrationRepository;
import com.itmo.projects_registration.model.Company;
import com.itmo.projects_registration.model.Registration;

@Service
public class RegistrationService {

	private final RegistrationRepository registrationRepo;
	
	public RegistrationService(RegistrationRepository registrationRepo) {
	
		this.registrationRepo = registrationRepo;
	}


//	find all registrations matching exact criteria
	public List<Registration> findRegistrationByExample(Registration registration){
		Example<Registration> example = Example.of(registration);
		return registrationRepo.findAll(example);
	}
	
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
