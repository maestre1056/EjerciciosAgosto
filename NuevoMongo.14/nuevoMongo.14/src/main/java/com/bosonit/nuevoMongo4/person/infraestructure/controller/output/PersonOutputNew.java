package com.bosonit.nuevoMongo4.person.infraestructure.controller.output;

import com.bosonit.nuevoMongo4.person.domain.Person;
import lombok.Data;

import java.util.Date;
@Data
public class PersonOutputNew {
    private String id;
    private String username;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;

    public PersonOutputNew(Person person){
        this.id = person.getId();
        this.username = person.getUsername();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.companyEmail = person.getCompanyEmail();
        this.personalEmail= person.getPersonalEmail();
        this.city = person.getCity();
        this.createdDate = person.getCreatedDate();
    }
}
