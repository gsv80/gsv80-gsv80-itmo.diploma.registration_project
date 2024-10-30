package com.itmo.projects_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.ContactRepository;
import com.itmo.projects_registration.model.Contact;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepo;
	
	public List<Contact> listAll(){
		return (List<Contact>) contactRepo.findAll();
	}
	
	public void save(Contact contact) {
		contactRepo.save(contact);
	}
	
	public Contact get(Long id) {
		return contactRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		contactRepo.deleteById(id);
	}

}
