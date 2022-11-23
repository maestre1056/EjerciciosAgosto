package com.bosonit.ej15.security.person.infraestructure.repository;

import com.bosonit.ej15.security.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional <Person>findByUsername(String username);
}
