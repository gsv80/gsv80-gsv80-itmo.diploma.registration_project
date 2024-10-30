package com.itmo.projects_registration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
    public OpenAPI registrationsDatabaseOpenAPI() {
        return new OpenAPI()
            .info(new Info()
    		.title("Project registrations REST API")
    		.description("A company registrations manager app")
    		.version("1.0"));
	}

}
