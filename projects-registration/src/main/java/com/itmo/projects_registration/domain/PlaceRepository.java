package com.itmo.projects_registration.domain;

import org.springframework.data.repository.CrudRepository;

import com.itmo.projects_registration.model.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {

}
