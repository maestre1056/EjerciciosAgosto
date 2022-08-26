package com.example.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PersonGet {
    @Autowired
    Crud crud;

    @GetMapping("{id}")
    public  Greeting1 getPersonaId(@PathVariable int id){
        return crud.getPersonaById(id);
    }

    @GetMapping("/name/{name}")
    public  Greeting1 getPersonaName(@PathVariable String name){
        return crud.getPersonaByName(name);
    }
}
