package com.bosonit.crud.persona.infraestructure;

import com.bosonit.crud.persona.application.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class DeleteController {

    @Autowired
    PersonaServiceImp personaServiceImp;

    @DeleteMapping("/id/{id}")
    public String deleteId(@PathVariable Long id){
        personaServiceImp.delete(id);

        return "Persona borrada";
    }
}
