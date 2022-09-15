package com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output;

import com.example.ej7.crudvalidation.estudiante.domain.Estudiante;
import com.example.ej7.crudvalidation.estudios.domain.Estudios;
import com.example.ej7.crudvalidation.persona.domain.Person;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonOutput;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Data;

import java.util.List;

@Data
public class EstudianteOutputDto {
    private String id_student;
    private PersonOutput person;
    private Integer num_hours_week;
    private String comments;
    private Profesor profesor;
    private String branch;


    public EstudianteOutputDto (Estudiante estudiante){
      setId_student(estudiante.getId_student());
      setPerson(new PersonOutput(estudiante.getPerson()));
      setNum_hours_week(estudiante.getNum_hours_week());
      setComments(estudiante.getComments());
      //setProfesor();
    }
}
