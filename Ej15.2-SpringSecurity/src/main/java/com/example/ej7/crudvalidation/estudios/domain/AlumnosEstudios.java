package com.example.ej7.crudvalidation.estudios.domain;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class AlumnosEstudios {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEstudios;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfesor")
    private Profesor profesor;

    @ManyToMany(mappedBy = "estudios")
    private List<Student> students;

    @Column
    private String asignatura;

    @Column
    private String comment;

    @Column(nullable = false)
    private Date initialDate;

    @Column
    private Date finishDate;

}
