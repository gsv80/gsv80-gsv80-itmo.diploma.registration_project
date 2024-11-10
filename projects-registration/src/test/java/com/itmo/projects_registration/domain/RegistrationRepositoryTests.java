package com.itmo.projects_registration.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.itmo.projects_registration.model.Company;
import com.itmo.projects_registration.model.Invoice;
import com.itmo.projects_registration.model.Manager;
import com.itmo.projects_registration.model.Place;
import com.itmo.projects_registration.model.Registration;
import com.itmo.projects_registration.model.RoleEnum;

@DataJpaTest
public class RegistrationRepositoryTests {
	
	@Autowired
	private RegistrationRepository registrationRepository;

	
	@Test
	void saveRegistrationTest() {
		
		Registration registration = new Registration();
		registrationRepository.save(registration);
		assertThat(registrationRepository.findAll().size()).isGreaterThan(0);
	}
	
	@Test
	public void RegistrationRepositorySaveAllReturnSavedRegistration() {
		
		Registration registration1 = new Registration("testNum", new Manager(), new Manager(), new Place(), new Company(), null, true);
		Registration registration2 = new Registration();
		
		registrationRepository.save(registration1);
		registrationRepository.save(registration2);
		
		assertThat(registrationRepository.findAll().size()).isEqualTo(2);
		assertThat(registrationRepository.findByRegistrationId("testNum").size()).isEqualTo(1);
		
	}
	

	
	
}
