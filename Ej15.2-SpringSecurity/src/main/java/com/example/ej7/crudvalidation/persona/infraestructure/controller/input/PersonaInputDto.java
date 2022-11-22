package com.example.ej7.crudvalidation.persona.infraestructure.controller.input;

import com.example.ej7.crudvalidation.role.domain.Role;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class PersonaInputDto {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String city;
    private boolean active;
    private Date createdDate;
    private String imagenUrl;
    private Date terminateDate;

    private Collection<Role> roles;


    public PersonaInputDto(String username, String password, String name, String surname, String companyEmail, String city,
                           boolean active, Date createdDate, String imagenUrl, Date terminateDate,Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.companyEmail = companyEmail;
        this.city = city;
        this.active = active;
        this.createdDate = createdDate;
        this.imagenUrl = imagenUrl;
        this.terminateDate = terminateDate;
        this.roles=roles;
    }
}
