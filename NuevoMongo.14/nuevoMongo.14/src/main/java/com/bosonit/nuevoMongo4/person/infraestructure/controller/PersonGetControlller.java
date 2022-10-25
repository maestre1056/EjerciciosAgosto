package com.bosonit.nuevoMongo4.person.infraestructure.controller;

import com.bosonit.nuevoMongo4.person.application.PersonService;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.output.PersonOutputNew;
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
    public PersonOutputDto findById(@PathVariable String id){
        return  personService.findById(id);
    }


    @GetMapping("/person/page/{page}")
    public Page<PersonOutputNew> getPage(@PathVariable Integer page){
        return  personService.getAll(page);
    }
}
