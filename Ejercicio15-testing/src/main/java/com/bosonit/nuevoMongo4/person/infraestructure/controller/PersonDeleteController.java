package com.bosonit.nuevoMongo4.person.infraestructure.controller;

import com.bosonit.nuevoMongo4.person.application.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonDeleteController {

    @Autowired
    PersonService personService;

    @DeleteMapping("person/{id}")
    public String deletePerson(@PathVariable Long id){

      return   personService.deletePerson(id);
    }
}
