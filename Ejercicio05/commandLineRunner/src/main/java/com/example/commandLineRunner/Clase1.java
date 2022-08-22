package com.example.commandLineRunner;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Clase1 {
    @PostConstruct
    public void inicial(){
        System.out.println("Soy la clase inicial");
    }
}