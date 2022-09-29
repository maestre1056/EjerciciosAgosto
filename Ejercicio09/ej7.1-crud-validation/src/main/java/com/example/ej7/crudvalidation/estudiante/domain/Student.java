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
    private Long idStudent;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @Column(nullable = false)
    private Integer numHoursWeek;

    @Column
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfesor")
    private Profesor profesor;

    @Column(nullable = false)
    private String rama;

    @ManyToMany( fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(name = "estudios_student",
            joinColumns = @JoinColumn(name = "id_studios",
                    referencedColumnName = "idStudent"),
            inverseJoinColumns = @JoinColumn(name = "id_estudios", referencedColumnName = "idEstudios"))
    private List<AlumnosEstudios> estudios;


}
