package com.bosonit.crud.persona.infraestructure;

import com.bosonit.crud.persona.application.PersonaServiceImp;
import com.bosonit.crud.persona.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class GetController {
    @Autowired
    PersonaServiceImp personaServiceImp;


    @GetMapping("/name/{name}")
    public List<Persona> personaByName(@PathVariable String name){
        List<Persona> p1 =personaServiceImp.findByName(name);

        return p1;
    }

    @GetMapping("/id/{id}")
    public Persona findById(@PathVariable int id){
        Persona personId=personaServiceImp.findById(id);
        return personId;

    }

    @GetMapping("/lista")
    public List<Persona> listar(){
        return personaServiceImp.listarLista();
    }
}
