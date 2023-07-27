package com.petshopSystem.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigSwagger {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("PetShop System")
						.description("Web system with the main objective of storing"
								+ " and sending reports of animals entering the petshop "
								+ "to the owners in order to avoid problems with animals "
								+ "that enter the store already injured. It also has a record "
								+ "of appointments and customer data.")
						.version("Versão 1.0.0")
						.contact(new Contact()
								.name("João Dal Lago")
								.email("joaogabrieldallago@hotmail.com")));
	}

}
