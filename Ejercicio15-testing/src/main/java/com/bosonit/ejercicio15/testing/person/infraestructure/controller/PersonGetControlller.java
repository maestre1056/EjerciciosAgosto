package com.bosonit.ejercicio15.testing.person.infraestructure.controller;

import com.bosonit.ejercicio15.testing.person.application.PersonService;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.output.PersonOutputNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonGetControlller {
    @Autowired
    PersonService personService;

    @GetMapping("/person/username/{username}")
    public List<PersonOutputDto>  findByUsername(@PathVariable String username){
        return personService.findPeopleByUsername(username);
    }

    @GetMapping("/person/id/{id}")
    public PersonOutputDto findById(@PathVariable Long id){
        return  personService.findById(id);
    }


    @GetMapping("/person/page/{page}")
    public Page<PersonOutputNew> getPage(@PathVariable Integer page){
        return  personService.getAll(page);
    }

    @GetMapping("person/all")
    public List<PersonOutputDto> getALl(){
        return personService.findAll();
    }
}
