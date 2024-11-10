package com.itmo.projects_registration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itmo.projects_registration.domain.CompanyRepository;
import com.itmo.projects_registration.domain.ContactRepository;
import com.itmo.projects_registration.domain.DepartmentRepository;
import com.itmo.projects_registration.domain.EquipmentRepository;
import com.itmo.projects_registration.domain.InvoiceRepository;
import com.itmo.projects_registration.domain.ManagerRepository;
import com.itmo.projects_registration.domain.PlaceRepository;
import com.itmo.projects_registration.domain.RegistrationRepository;
import com.itmo.projects_registration.model.Company;
import com.itmo.projects_registration.model.Contact;
import com.itmo.projects_registration.model.Department;
import com.itmo.projects_registration.model.Equipment;
import com.itmo.projects_registration.model.Invoice;
import com.itmo.projects_registration.model.Manager;
import com.itmo.projects_registration.model.Place;
import com.itmo.projects_registration.model.Registration;
import com.itmo.projects_registration.model.RoleEnum;

@SpringBootApplication
public class ProjectsRegistrationApplication implements CommandLineRunner {
	
	public ProjectsRegistrationApplication(CompanyRepository companyRepo,
			ContactRepository contactRepo, DepartmentRepository depRepo, EquipmentRepository equipRepo,
			InvoiceRepository invoiceRepo, ManagerRepository managerRepo, PlaceRepository placeRepo,
			RegistrationRepository registrRepo) {
		super();
		this.companyRepo = companyRepo;
		this.contactRepo = contactRepo;
		this.depRepo = depRepo;
		this.equipRepo = equipRepo;
		this.invoiceRepo = invoiceRepo;
		this.managerRepo = managerRepo;
		this.placeRepo = placeRepo;
		this.registrRepo = registrRepo;
	}

	private static final Logger logger = LoggerFactory.getLogger(
			ProjectsRegistrationApplication.class
	);
	
	//test filling db with data
	
	private final CompanyRepository companyRepo;
	private final ContactRepository contactRepo;
	private final DepartmentRepository depRepo;
	private final EquipmentRepository equipRepo;
	private final InvoiceRepository invoiceRepo;
	private final ManagerRepository managerRepo;
	private final PlaceRepository placeRepo;
	private final RegistrationRepository registrRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(ProjectsRegistrationApplication.class, args);
		logger.info("Application started");
	}
	
	@Override
    public void run(String... args) throws Exception {
		
		Equipment equipment1 = new Equipment("WQ" );
		Equipment equipment2 = new Equipment("SSC");
		//equipRepo.saveAll(Arrays.asList(equipment1, equipment2));
		
		Department depTech = new Department("Tech support");
		Department depSales = new Department("Sales");
		depRepo.saveAll(Arrays.asList(depTech, depSales));
		
		Manager manager1 = new Manager("ivan", "ivanov", RoleEnum.USER, depTech , "user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue");
		Manager manager2 = new Manager("petr", "petrov", RoleEnum.ADMIN, depSales, "admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW");
		managerRepo.saveAll(Arrays.asList(manager1, manager2));
		
		Company company1 = new Company("TD sales", "OOO", 1234567890L, "sales");
		Company company2 = new Company("Vodokanal Tver", "MUP", 1234567891L, "end user");
	//	companyRepo.saveAll(Arrays.asList(company1, company2));
		
		Contact contact1 = new Contact("Anton", "Gavrilin", "Sales Manager", company1, 9031234567L);
		Contact contact2 = new Contact("Kirill", "Vasilkov", "Sales Manager", company1, 9031234568L, 4951234567L);
		Contact contact3 = new Contact("Michail", "Dynin", "Engineer", company2, 9271234567L);
		//contactRepo.saveAll(Arrays.asList(contact1, contact2, contact3));
		
		Place place1 = new Place("Tverskaya", "Tver", "Moskovskoe av.", "1", 123456, "KNS-1", company2);
		Place place2 = new Place("Tverskaya", "Tver", "Pobedy av.", "65 ", 123456, "KNS-2", company2);
		Place place3 = new Place("Tverskaya", "Tver", "Moskovskoe av.", "11B ", 123456, "KNS-5", company2);
		//placeRepo.saveAll(Arrays.asList(place1, place2, place3));
		
		
		
		Registration reg1 = new Registration("kb0304856", manager2, manager2, place1, company1, null, false);
		
		Equipment equipment3 = new Equipment("WQ-W" );
		Equipment equipment4 = new Equipment("SSC-G");
		
		
		//equipRepo.saveAll(Arrays.asList(equipment1, equipment2));
		reg1.addEquipment(equipment3);
		reg1.addEquipment(equipment2);
		
		Registration reg2 = new Registration("kb0304857", manager2, manager2, place3, company1, null, true);
		reg2.addEquipment(equipment4);
		
		Registration reg3 = new Registration("kb0304859", manager2, manager2, place2, company1, null, true);
		reg3.addEquipment(equipment1);
		
		
		//registrRepo.saveAll(Arrays.asList(reg1, reg2, reg3));
		
		Invoice invoice1 = new Invoice("PPI-060924-1112", 110000D, true, manager1, reg1);
		Invoice invoice2 = new Invoice("PPI-060924-1114", 1000D, false, manager2, reg1);
		Invoice invoice3 = new Invoice("PPI-060924-1116", 110000D, false, manager1, reg2);
		Invoice invoice4 = new Invoice("PPI-060924-1123", 60000D, false, manager1, reg3);
		//invoiceRepo.saveAll(Arrays.asList(invoice1, invoice2, invoice3, invoice4));
		
		for (Equipment equipment : equipRepo.findAll()) {
	        logger.info("type: {}",
	            equipment.getEquipmentType());
		}
	}

}
