package com.itmo.projects_registration.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itmo.projects_registration.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>, PagingAndSortingRepository<Department, Long> {

}
