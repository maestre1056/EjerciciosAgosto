package com.example.ej7.crudvalidation.profesor.domain;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id_profesor;

    @OneToOne
    @JoinColumn(name = "id")
    Persona persona;

    @Column
    String comments;

    @Column(nullable = false)
    String branch;
}
