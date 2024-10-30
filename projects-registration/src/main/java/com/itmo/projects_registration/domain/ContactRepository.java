package com.itmo.projects_registration.domain;

import org.springframework.data.repository.CrudRepository;

import com.itmo.projects_registration.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
