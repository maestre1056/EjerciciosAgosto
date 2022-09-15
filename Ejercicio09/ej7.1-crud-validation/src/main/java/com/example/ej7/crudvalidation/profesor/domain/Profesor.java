package com.example.ej7.crudvalidation.profesor.domain;

import com.example.ej7.crudvalidation.persona.domain.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id_profesor;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person id_persona;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;

}
