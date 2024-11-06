package com.itmo.projects_registration.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({CompanyController.class})
public class CompanyControllerTests {

	@Autowired
	MockMvc mvc;
	
	@Test
	void rootWhenUnauthenticatedThen401() throws Exception {
		// @formatter:off
		this.mvc.perform(get("/companies"))
				.andExpect(status().isUnauthorized());
		// @formatter:on
	}

//	@Test
//	void tokenWhenBadCredentialsThen401() throws Exception {
//		// @formatter:off
//		this.mvc.perform(post("/companies"))
//				.andExpect(status().isUnauthorized());
//		// @formatter:on
//	}
}
