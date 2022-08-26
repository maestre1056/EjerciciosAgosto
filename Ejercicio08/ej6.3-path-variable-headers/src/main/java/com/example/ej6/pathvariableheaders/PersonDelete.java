package com.example.ej6.pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PersonDelete {
    @Autowired
    Crud crud;

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable int id){
         crud.deletePerson(id);
    }

}
