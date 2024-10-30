package com.itmo.projects_registration.domain;

import org.springframework.data.repository.CrudRepository;

import com.itmo.projects_registration.model.Equipment;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

	
}
