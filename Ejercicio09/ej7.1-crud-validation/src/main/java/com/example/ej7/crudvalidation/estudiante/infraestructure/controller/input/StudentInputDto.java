package com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input;

import com.example.ej7.crudvalidation.estudios.domain.AlumnosEstudios;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputIdDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputIdDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputIdDto;
import lombok.Data;

import java.util.List;

@Data
public class StudentInputDto {
    private PersonaInputIdDto persona;
    private Integer numHoursWeek;
    private String comments;
    private ProfesorInputIdDto profesor;
    private String rama;
    private List<EstudiosInputIdDto> estudios;
}
