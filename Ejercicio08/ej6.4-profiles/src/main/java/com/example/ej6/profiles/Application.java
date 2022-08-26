package com.example.ej6.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		MainController mainController=new MainController();

		mainController.getValores();
		//mainController.getPassword();
	}

}
