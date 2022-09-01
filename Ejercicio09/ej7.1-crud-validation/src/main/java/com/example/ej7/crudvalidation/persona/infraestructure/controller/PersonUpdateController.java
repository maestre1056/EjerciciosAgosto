package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.persona.application.PersonServiceImp;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonInput;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonUpdateController {
    @Autowired
    PersonServiceImp personServiceImp;

    @PutMapping("/person/{id}")
    public PersonOutput updatePerson(@PathVariable int id, @RequestBody PersonInput personInput)throws Exception{
        return personServiceImp.updatePerson(id,personInput);
    }
}
