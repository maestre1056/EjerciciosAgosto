package com.bosonit.nuevoMongo4.person.infraestructure.repository;

import com.bosonit.nuevoMongo4.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByUsername(String username);
    Page<Person> findAll(Pageable pageable);
}
