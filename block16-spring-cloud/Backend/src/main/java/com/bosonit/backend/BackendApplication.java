package com.bosonit.backend;

import com.bosonit.backend.client.application.ClientService;
import com.bosonit.backend.client.infrastructure.dto.ClientInputDto;
import com.bosonit.backend.travel.application.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication  {


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}



}
