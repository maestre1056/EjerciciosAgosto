package com.example.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class Clase2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy segunda clase");
    }
}
