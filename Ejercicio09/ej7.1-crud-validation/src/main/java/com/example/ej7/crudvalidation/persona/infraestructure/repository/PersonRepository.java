package com.example.ej7.crudvalidation.persona.infraestructure.repository;

import com.example.ej7.crudvalidation.persona.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    List<Person> findByUsername(String user);
}
