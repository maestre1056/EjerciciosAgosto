package com.bosonit.crud.persona.infraestructure;

import com.bosonit.crud.persona.application.PersonaServiceImp;
import com.bosonit.crud.persona.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PostController {
    @Autowired
    PersonaServiceImp personaServiceImp;

    @PostMapping("")
    public String addPersona(@RequestBody Persona persona){
        personaServiceImp.addPersona(persona);

        return "Persona añadida";
    }
}
