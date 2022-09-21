package com.example.ej7.crudvalidation.persona.infraestructure.controller.input;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import lombok.Data;

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









}
