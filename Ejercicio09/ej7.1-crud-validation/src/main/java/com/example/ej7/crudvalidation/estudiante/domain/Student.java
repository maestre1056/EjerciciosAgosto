package com.example.ej7.crudvalidation.estudiante.domain;

import com.example.ej7.crudvalidation.estudios.domain.AlumnosEstudios;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_student;

    @OneToOne
    @JoinColumn(name = "id")
    private Persona persona;

    @Column(nullable = false)
    private Integer numHoursWeek;

    @Column
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column(nullable = false)
    private String rama;

    @OneToMany
    @JoinColumn(name = "asignatura")
    private List<AlumnosEstudios> estudios;


}
