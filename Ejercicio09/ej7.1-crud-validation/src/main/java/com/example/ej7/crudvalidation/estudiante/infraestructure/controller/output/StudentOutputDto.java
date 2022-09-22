package com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output;

import com.example.ej7.crudvalidation.estudios.domain.AlumnosEstudios;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Data;

import java.util.List;

@Data
public class StudentOutputDto {
    private Long id_student;
    private Persona persona;
    private Integer numHoursWeek;
    private String comments;
    private Profesor profesor;
    private String rama;
    private List<AlumnosEstudios> estudios;
}
