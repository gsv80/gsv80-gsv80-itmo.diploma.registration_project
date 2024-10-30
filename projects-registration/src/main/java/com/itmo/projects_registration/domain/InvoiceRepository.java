package com.itmo.projects_registration.domain;

import org.springframework.data.repository.CrudRepository;

import com.itmo.projects_registration.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
