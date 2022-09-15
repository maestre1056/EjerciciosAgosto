package com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input;

import com.example.ej7.crudvalidation.estudiante.domain.Estudiante;
import com.example.ej7.crudvalidation.persona.domain.Person;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Data;

import java.util.Date;

@Data
public class EstudianteInputDto {
    private int id_person;
    private Integer num_hours_week;
    private String comments;
    private String id_profesor;
    private String branch;

    public Estudiante transformIntoEstudiante(Person person, Profesor profesor){
        Estudiante estudiante=new Estudiante();

        estudiante.setPerson(person);
        estudiante.setNum_hours_week(this.num_hours_week);
        estudiante.setComments(this.comments);
        estudiante.setProfesor(profesor);
        estudiante.setBranch(this.branch);

        return estudiante;
    }


}
