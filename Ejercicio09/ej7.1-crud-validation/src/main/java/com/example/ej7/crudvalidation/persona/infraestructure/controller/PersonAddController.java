package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.persona.application.PersonServiceImp;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonInput;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonAddController {
    @Autowired
    PersonServiceImp personServiceImp;

    @PostMapping("/persona")
    public PersonOutput addPerson(@RequestBody PersonInput personInput)throws Exception{
        return personServiceImp.addPerson(personInput);
    }
}
