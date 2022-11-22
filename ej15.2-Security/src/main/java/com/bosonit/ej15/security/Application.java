package com.bosonit.ej15.security;

import com.bosonit.ej15.security.person.application.PersonService;
import com.bosonit.ej15.security.person.infraestructure.dto.PersonDTO;
import com.bosonit.ej15.security.role.application.RoleService;
import com.bosonit.ej15.security.role.infraestructure.dto.RoleDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner run(PersonService personService, RoleService roleService) {
		return args -> {

			personService.addPerson(new PersonDTO(null, "maestransa", "1234", "Antonio", "Maestre", 28, new ArrayList<>()));
			personService.addPerson(new PersonDTO(null, "supersali", "manteqilla", "Fernando", "Hernandez", 29, new ArrayList<>()));

			roleService.addRole(new RoleDTO(null, "ADMIN"));
			roleService.addRole(new RoleDTO(null, "USER"));

			roleService.addRoleToPerson("maestransa", "ADMIN");
			roleService.addRoleToPerson("supersali", "USER");
		};
	}
}
