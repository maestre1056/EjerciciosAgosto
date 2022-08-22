package com.example.dependencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DependenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependenciasApplication.class, args);
	}
/*
	@Bean
	public void getCiudadService()
	{
		  List<Ciudad> ciudades=new ArrayList<>();
	}

 */
	@Bean
	public SpringApplicationAdminJmxAutoConfiguration pp() {
		return new SpringApplicationAdminJmxAutoConfiguration();
	}
	@Bean ("bean1")
	public void crearPersona1(){
		Persona persona1 = new Persona();

	}
	@Bean ("bean2")
	public void crearPersona2(){
		Persona persona2 = new Persona();

	}
	@Bean ("bean3")
	public void crearPersona3(){
		Persona persona3 = new Persona();

	}
}
