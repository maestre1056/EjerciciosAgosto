package com.bosonit.nuevoMongo4.person.infraestructure.controller.output;

import com.bosonit.nuevoMongo4.person.domain.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDto {
    private String id;
    private String username;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;



}
