package com.bosonit.crud.persona.infraestructure;

import com.bosonit.crud.persona.application.PersonaService;
import com.bosonit.crud.persona.application.PersonaServiceImp;
import com.bosonit.crud.persona.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PutController {

    @Autowired
    PersonaService personaService;

    @PutMapping("/persona/{id}")
    public Persona modificar(@PathVariable Long id,@RequestBody Persona persona){
        personaService.update(id,persona);
        return persona;
    }
}
