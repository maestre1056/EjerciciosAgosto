package com.example.ej7.crudvalidation.persona.infraestructure.controller.output;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.role.domain.Role;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.function.Function;

@Data
public class PersonaOutputDto  {
    private Long idPersona;
    private String username;
    private String name;
    private String surname;
    private String companyEmail;
    private String city;
    private Date createdDate;
    private String imagenUrl;
    private Date terminateDate;
    private Collection<Role> roles;



}
