package com.example.ej7.crudvalidation.persona.infraestructure.controller.output;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDtoNew {
    private Long idPersona;
    private String username;
    private String name;
    private String surname;
    private String companyEmail;
    private String city;
    private Date createdDate;
    private String imagenUrl;
    private Date terminateDate;

    public PersonaOutputDtoNew(Persona persona){
        this.idPersona=persona.getIdPersona();
        this.username= persona.getUsername();
        this.name= persona.getName();
        this.surname= persona.getSurname();
        this.companyEmail= persona.getCompanyEmail();
        this.city= persona.getCity();
        this.createdDate=persona.getCreatedDate();
        this.imagenUrl= persona.getImagenUrl();
        this.terminateDate=persona.getTerminationDate();
    }
}
