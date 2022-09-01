package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.persona.application.PersonServiceImp;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonFindController {
    @Autowired
    PersonServiceImp personServiceImp;

    @GetMapping("/person/all")
    public List<PersonOutput> getAllPeople(){
        return personServiceImp.getAllPeople();
    }

    @GetMapping("/person/{id}")
    public PersonOutput getPersonById(@PathVariable int id)throws Exception{
        return personServiceImp.findPersonById(id);
    }

    @GetMapping("/person/username/{username}")
    public List<PersonOutput> getPersonByUsername(@PathVariable String username)throws Exception{
        return personServiceImp.findPersonByUserName(username);
    }


}
