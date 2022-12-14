package com.bosonit3.mongo.person.infraestructure.controller;

import com.bosonit3.mongo.person.application.PersonService;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonGetController {
    @Autowired
    PersonService personService;

    @GetMapping("/person/username/{username}")
    public List<PersonOutputDto> findByUsername(@PathVariable String username){
        return personService.findPeopleByUsername(username);
    }

    @GetMapping("/person/id/{id}")
    public PersonOutputDto getById(@PathVariable Long id){
        return personService.findById(id);
    }

    @GetMapping("/person")
    public List<PersonOutputDto> getAll(){
        return personService.findPeople();
    }

}
