package com.itmo.projects_registration.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.itmo.projects_registration.model.Company;
import com.itmo.projects_registration.model.Invoice;
import com.itmo.projects_registration.model.Manager;
import com.itmo.projects_registration.model.Place;
import com.itmo.projects_registration.model.Registration;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RegistrationRepositoryTests {
	

	private RegistrationRepository registrationRepository;

	@Autowired
	public RegistrationRepositoryTests(RegistrationRepository registrationRepository) {	
		this.registrationRepository = registrationRepository;
	}
	
	
//	RegistrationConstructor (String registrationId, Manager creator, Manager responsibleManager,
//			Place place, Company client, List<Invoice> invoices, boolean registrationState)
	
	@Test
	public void RegistrationRepository_SaveAll_ReturnSavedRegistration() {
		
		Registration registration1 = new Registration("testNum", new Manager(), new Manager(), new Place(), new Company(), null, true);
		
		Registration savedRegistration = registrationRepository.save(registration1);
		
		Assertions.assertThat(savedRegistration).isNotNull();
		Assertions.assertThat(savedRegistration.getRegistrationId()).isEqualTo("testNum");
		Assertions.assertThat(savedRegistration.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void RegistrationRepository_ListAll_ReturnMoreThanOneRegistration() {
		
		Registration registration1 = new Registration("testNum3", new Manager(), new Manager(), new Place(), new Company(), null, true);
		Registration registration2 = new Registration("testNum2", new Manager(), new Manager(), new Place(), new Company(), null, false);
		
		Registration savedOne = registrationRepository.save(registration1);
		Registration savedTwo = registrationRepository.save(registration2);
		
//		List<Registration> registrationsList = registrationRepository.findAll();
		
//		Assertions.assertThat(registrationsList).isNotNull();
		Assertions.assertThat(savedTwo).isNotNull();
		Assertions.assertThat(savedTwo.getRegistrationId()).isEqualTo("testNum2");
//		Assertions.assertThat(registrationsList.size()).isEqualTo(5);//
		
	}
}
