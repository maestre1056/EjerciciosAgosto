package com.bosonit3.mongo.person.infraestructure.controller;

import com.bosonit3.mongo.person.application.PersonService;
import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonAddController {

    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public PersonOutputDto addPerson(@RequestBody PersonInputDto personInputDto){
        return personService.addPerson(personInputDto);
    }
}
