package com.bosonit.ejercicio15.testing.person.infraestructure.controller;

import com.bosonit.ejercicio15.testing.person.application.PersonService;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonUpdateController {

    @Autowired
    PersonService personService;

    @PutMapping("/person/{id}")
    public PersonOutputDto updatePerson(@PathVariable Long id, @RequestBody PersonInputDto personInputDto){
        return personService.update(id,personInputDto);
    }
}
