package com.itmo.projects_registration;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.itmo.projects_registration.domain.CompanyRepository;
import com.itmo.projects_registration.model.Company;

@DataJpaTest
public class CompanyRepositoryTest {

	@Autowired
	private CompanyRepository repository;
	
//	@Test
//	void saveCompany() {
//	    repository.save(new Company("PumpCo", "OOO", 1234567891L, "sales"));
//	    assertThat(
//	        repository.
//	    ).isTrue();
//	}
}
