package com.bosonit.ej15.security.person.infraestructure.controller;

import com.bosonit.ej15.security.person.application.PersonService;
import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.person.infraestructure.dto.PersonDTO;
import com.bosonit.ej15.security.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Object addPerson(@RequestBody PersonDTO personDTO) {
        try{
            return personService.addPerson(personDTO);
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Username already existed");
        }
    }

    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Long idPerson) throws Exception {
        return personService.getPersonById(idPerson);
    }

    @GetMapping("/username/{username}")
    public Optional<Person> getPersonByUsername(@PathVariable("username") String username) throws Exception {
        return personService.getPersonByUsername(username);
    }

    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable("id") Long idPerson, @RequestBody PersonDTO personDTO) {
        return new PersonDTO(personService.updatePerson(idPerson, personDTO));
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Long idPerson) {
        try {
            personService.deletePerson(idPerson);
            return "The person with idPerson " + idPerson + " has been successfully eliminated.";
        } catch (Exception ex) {
            return "Error: " + ex.getMessage();
        }
    }
}
