package com.example.ej7.crudvalidation.estudios.infraestructure.controller.input;

import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputIdDto;
import lombok.Data;

import java.util.Date;

@Data
public class EstudiosInputDto {

    private ProfesorInputIdDto profesor;

    private String asignatura;

    private String comment;

    private Date initialDate;

    private Date finishDate;


}
