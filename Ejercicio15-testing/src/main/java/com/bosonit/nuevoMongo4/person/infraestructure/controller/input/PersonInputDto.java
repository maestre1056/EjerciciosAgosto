package com.bosonit.nuevoMongo4.person.infraestructure.controller.input;

import lombok.Data;

import java.util.Date;

@Data
public class PersonInputDto {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;



    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;

    public PersonInputDto(String username, String password, String name, String surname, String companyEmail, String personalEmail, String city, boolean active, Date createdDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.companyEmail = companyEmail;
        this.personalEmail = personalEmail;
        this.city = city;
        this.active = active;
        this.createdDate = createdDate;
    }

}


