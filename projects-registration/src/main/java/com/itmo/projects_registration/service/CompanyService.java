package com.itmo.projects_registration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.CompanyRepository;
import com.itmo.projects_registration.model.Company;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	public List<Company> listAll(){
		return (List<Company>) companyRepo.findAll();
	}
	
	public void save(Company company) {
		companyRepo.save(company);
	}
	
	public Company get(Long id) {
		return companyRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		companyRepo.deleteById(id);
	}
	
	
}
