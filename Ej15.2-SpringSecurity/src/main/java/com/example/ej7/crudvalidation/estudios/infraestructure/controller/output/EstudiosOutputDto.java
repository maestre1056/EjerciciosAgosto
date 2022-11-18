package com.example.ej7.crudvalidation.estudios.infraestructure.controller.output;

import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EstudiosOutputDto {
    private Long idEstudios;

    private ProfesorOutputDto profesor;

    private String asignatura;

    private String comment;

    private Date initialDate;

    private Date finishDate;

    private List<StudentOutputDto> studentsList;
}
