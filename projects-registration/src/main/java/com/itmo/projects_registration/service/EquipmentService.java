package com.itmo.projects_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.EquipmentRepository;
import com.itmo.projects_registration.model.Equipment;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipRepo;
	
	public List<Equipment> listAll(){
		return (List<Equipment>) equipRepo.findAll();
	}
	
	public void save(Equipment equipment) {
		equipRepo.save(equipment);
	}
	
	public Equipment get(Long id) {
		return equipRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		equipRepo.deleteById(id);
	}
	
}
