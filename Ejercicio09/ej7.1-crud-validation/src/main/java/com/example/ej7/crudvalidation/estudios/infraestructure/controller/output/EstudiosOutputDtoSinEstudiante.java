package com.example.ej7.crudvalidation.estudios.infraestructure.controller.output;

import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.Data;

import java.util.Date;

@Data
public class EstudiosOutputDtoSinEstudiante {
    private Long id_estudios;

    private ProfesorOutputDto profesorOutputDto;

    private String asignatura;

    private String comments;

    private Date initial_date;

    private Date finish_date;
}
