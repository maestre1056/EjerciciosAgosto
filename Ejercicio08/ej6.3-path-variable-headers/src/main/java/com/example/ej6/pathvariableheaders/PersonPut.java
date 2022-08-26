package com.example.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class PersonPut {

    @Autowired
    Crud crud;

    @PutMapping("{id}")
    public String editPersona(@PathVariable int id, @RequestBody Greeting1 newPersonData){
        crud.modifyPerson(id,newPersonData);
        return "Persona modificada";
    }
}
