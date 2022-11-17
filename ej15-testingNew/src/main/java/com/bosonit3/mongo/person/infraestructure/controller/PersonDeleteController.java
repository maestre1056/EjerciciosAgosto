package com.bosonit3.mongo.person.infraestructure.controller;

import com.bosonit3.mongo.person.application.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonDeleteController {
    @Autowired
    PersonService personService;

    @DeleteMapping("person/{id}")
    public String delete(@PathVariable Long id){
        return personService.deletePerson(id);
    }
}
