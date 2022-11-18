package com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output;

import com.example.ej7.crudvalidation.estudios.domain.AlumnosEstudios;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.output.EstudiosOutputDto;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.Data;

import java.util.List;

@Data
public class StudentOutputDto {
    private Long idStudent;
    private PersonaOutputDto persona;
    private Integer numHoursWeek;
    private String comments;
    private ProfesorOutputDto profesor;
    private String rama;
    private List<EstudiosOutputDto> estudios;
}
