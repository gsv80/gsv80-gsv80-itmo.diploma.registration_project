package com.itmo.projects_registration.domain;

import org.springframework.data.repository.CrudRepository;

import com.itmo.projects_registration.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
