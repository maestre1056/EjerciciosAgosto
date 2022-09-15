package com.example.ej7.crudvalidation.estudiante.domain;

import com.example.ej7.crudvalidation.estudios.domain.Estudios;
import com.example.ej7.crudvalidation.persona.domain.Person;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
public class Estudiante {

    @Id
    @GeneratedValue(generator ="estudiante-seq" )
    @GenericGenerator(name = "estudiante-seq",
    strategy="com.example.ej7.crudvalidation.estudiante.generators.Generator")
    private String id_student;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @Column(nullable = false)
    private Integer num_hours_week;

    @Column
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesor")
    private Profesor profesor;

    @Column(nullable=false)
    private String branch;

    @ManyToMany
    private List<Estudios> estudios;

}
