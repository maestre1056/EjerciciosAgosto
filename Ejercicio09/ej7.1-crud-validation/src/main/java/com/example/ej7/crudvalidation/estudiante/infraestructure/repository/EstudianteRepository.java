package com.example.ej7.crudvalidation.estudiante.infraestructure.repository;

import com.example.ej7.crudvalidation.estudiante.domain.Estudiante;
import com.example.ej7.crudvalidation.persona.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,String> {
  Optional<Estudiante> findByPerson(Person person);
}
