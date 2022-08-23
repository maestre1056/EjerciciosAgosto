package com.example.properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${greeting}")
    private  String greeting;

    @Value("${my.number}")
    private int number;

    @Value("${new.property:new.property no tiene valor}")
    private String newProperty;

    public String getGreeting() {
        return greeting;
    }

    public int getNumber() {
        return number;
    }

    public String getNewProperty() {
        return newProperty;
    }
}










