package com.bosonit3.mongo.person.infraestructure.controller;

import com.bosonit3.mongo.person.application.PersonService;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaGetController {
    @Autowired
    PersonService personService;

    @GetMapping("/person/username/{username}")
    public List<PersonOutputDto> findByUsername(@PathVariable String username){
        return personService.findPeopleByUsername(username);
    }

    @GetMapping("{arg2}")
    public String getParam(@PathVariable String arg2){
        return String.format("Lammado getparam1",arg2);
    }
    @GetMapping("{arg1}")
    public String getParam2(@PathVariable String arg1){
        return String.format("Lammado getparam1",arg1);
    }

}
