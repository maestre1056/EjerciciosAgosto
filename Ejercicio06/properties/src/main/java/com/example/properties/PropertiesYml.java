package com.example.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("properties.yaml")
@Component
public class PropertiesYml  {
    @Value("${greeting1}")
    private String greeting1;

    @Value("${my.number1}")
    private int number1;

    public String getGreeting1() {
        return greeting1;
    }

    public void setGreeting1(String greeting1) {
        this.greeting1 = greeting1;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }
}
