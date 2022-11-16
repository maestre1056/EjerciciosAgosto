package com.bosonit3.mongo.person.infraestructure.repository;

import com.bosonit3.mongo.person.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<Person ,Long> {
    List<Person> findByUsername(String username);
    Page<Person> findAll(Pageable pageable);
}
