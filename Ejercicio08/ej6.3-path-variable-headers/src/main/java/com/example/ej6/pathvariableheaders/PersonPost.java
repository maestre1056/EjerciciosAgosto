package com.example.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PersonPost {
    @Autowired
    Crud crud;

    @PostMapping()
    public String addPerson(@RequestBody Greeting1 newPerson){
        crud.addPersonList(newPerson);
        return  "Nueva persona";
    }

}
