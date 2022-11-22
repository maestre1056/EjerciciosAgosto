package com.bosonit.ej15.security.person.infraestructure.repository;

import com.bosonit.ej15.security.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
