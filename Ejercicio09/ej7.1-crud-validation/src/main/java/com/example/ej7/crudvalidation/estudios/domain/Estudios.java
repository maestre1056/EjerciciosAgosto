package com.example.ej7.crudvalidation.estudios.domain;

import com.example.ej7.crudvalidation.estudiante.domain.Estudiante;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profesor_id")
    private Profesor profesor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Estudiante estudiante;

    @Column(name="asignatura")
    private String asignatura;

    @Column(name="comments")
    private String comments;

    @Column(name="initial_date")
    private Date initial_date;

    @Column(name="finish_date")
    private Date finish_date;
}
