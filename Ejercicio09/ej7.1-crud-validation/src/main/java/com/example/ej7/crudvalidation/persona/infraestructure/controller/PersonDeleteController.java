package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.persona.application.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public  class PersonDeleteController {

    @Autowired
    PersonServiceImp personServiceImp;

    @DeleteMapping("person/{id}")
    public String deletePerson(@PathVariable int id)throws Exception{
        return  personServiceImp.deletePerson(id);
    }
}