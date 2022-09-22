package com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import lombok.Data;

@Data
public class StudentAllDetailsDto {
    private Long id;
    private Integer numHoursWeek;
    private String comments;
    private Persona id_Persona;
    private Persona username;
    private Persona password;
    private Persona name;
    private Persona surname;
    private Persona companyEmail;
    private Persona city;
    private Persona active;
    private Persona createdDate;
    private Persona imagenUrl;
    private Persona terminateDate;
}
