package com.example.ej7.crudvalidation.profesor.domain;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProfesor;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;
}
