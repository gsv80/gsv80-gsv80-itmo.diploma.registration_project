package com.itmo.projects_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmo.projects_registration.domain.PlaceRepository;
import com.itmo.projects_registration.model.Place;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepository placeRepo;
	
	public List<Place> listAll(){
		return (List<Place>) placeRepo.findAll();
	}
	
	public void save(Place company) {
		placeRepo.save(company);
	}
	
	public Place get(Long id) {
		return placeRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		placeRepo.deleteById(id);
	}
	
}
