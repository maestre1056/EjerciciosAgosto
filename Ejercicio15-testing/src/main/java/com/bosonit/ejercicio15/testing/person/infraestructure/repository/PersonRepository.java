package com.bosonit.ejercicio15.testing.person.infraestructure.repository;

import com.bosonit.ejercicio15.testing.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByUsername(String username);
    Page<Person> findAll(Pageable pageable);
}
