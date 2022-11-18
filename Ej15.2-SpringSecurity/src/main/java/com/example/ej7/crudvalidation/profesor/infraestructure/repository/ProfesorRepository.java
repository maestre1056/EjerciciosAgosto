package com.example.ej7.crudvalidation.profesor.infraestructure.repository;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

    Optional<Profesor> findByPersona(Persona persona);
}
