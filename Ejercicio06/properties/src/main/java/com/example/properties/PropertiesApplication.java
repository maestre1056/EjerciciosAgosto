package com.example.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertiesApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(PropertiesApplication.class, args);
	}

	@Autowired
	Properties properties;

	@Autowired
	PropertiesYml propertiesYml;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("greeting = " + properties.getGreeting());
		System.out.println("number = " + properties.getNumber());
		System.out.println("new.property = " + properties.getNewProperty());
		System.out.println("propertiesYml = " + propertiesYml.getGreeting1());
		System.out.println("propertiesYml = " + propertiesYml.getNumber1());
	}
}
