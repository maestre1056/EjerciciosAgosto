package com.example.ej7.crudvalidation.estudios.infraestructure.repository;

import com.example.ej7.crudvalidation.estudios.domain.AlumnosEstudios;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudiosRepository extends JpaRepository<AlumnosEstudios,Long> {
    List<AlumnosEstudios> findByProfesor(Profesor profesor);
}
