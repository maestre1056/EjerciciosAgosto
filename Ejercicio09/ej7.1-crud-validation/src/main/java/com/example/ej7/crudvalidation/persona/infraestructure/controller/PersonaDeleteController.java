package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaDeleteController {
    @Autowired
    PersonaService personaService;

    @DeleteMapping("/persona/{id}")
    public String deletePersona(@PathVariable Long id){
        return personaService.delete(id);
    }
}
