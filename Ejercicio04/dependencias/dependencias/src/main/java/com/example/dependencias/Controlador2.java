package com.example.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {

    @Autowired
    PersonaService personaService;

    @Autowired

    CiudadService ciudadService;

    @GetMapping("/Controlador2/getPersona")
    public Persona ponEdad() {
        personaService.getPersona().setEdad(personaService.getPersona().getEdad() * 2);
        return personaService.getPersona();
    }
    @GetMapping("controlador2/getCiudad")
    public List<Ciudad> getCiudad(){
        return ciudadService.getCiudad();

    }


}
