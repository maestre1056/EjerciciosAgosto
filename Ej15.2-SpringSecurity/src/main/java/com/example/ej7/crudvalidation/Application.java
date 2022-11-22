package com.example.ej7.crudvalidation;

import com.example.ej7.crudvalidation.persona.application.PersonaService;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.repository.PersonaRepository;
import com.example.ej7.crudvalidation.role.application.RoleService;
import com.example.ej7.crudvalidation.role.infraestructure.dto.RoleInputDto;
import com.example.ej7.crudvalidation.role.infraestructure.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner run(PersonaService personaService, RoleService roleService){
		return args -> {
			Date date = new Date();
			personaService.addPersona(new PersonaInputDto("maestransa","1321","Antonio","Maestre",
					"antonio.maes@gmail","Cordoba",false, date,"",null,
					new ArrayList<>()));
			personaService.addPersona(new PersonaInputDto("lourditas","1321","Lou","Rios",
					"antonio.maes@gmail","Cordoba",false, date,"",null,
					new ArrayList<>()));

			roleService.addRole(new RoleInputDto("ROLE_USER"));
			roleService.addRole(new RoleInputDto("ROLE_ADMIN"));

			roleService.addRoleToUser("maestransa","ROLE_ADMIN");
			roleService.addRoleToUser("lourditas","ROLE_USER");

		};


	}

}
