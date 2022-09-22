package com.example.ej7.crudvalidation.estudios.domain;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class AlumnosEstudios {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_student")
    Student student;

    @Column
    String asignatura;

    @Column
    String comment;

    @Column(nullable = false)
    Date initialDate;

    @Column
    Date finishDate;

}
