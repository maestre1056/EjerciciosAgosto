package com.example.ej7.crudvalidation.persona.infraestructure.controller.output;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDto {
    private Long idPersona;
    private String username;
    private String name;
    private String surname;
    private String companyEmail;
    private String city;
    private Date createdDate;
    private String imagenUrl;
    private Date terminateDate;


}
