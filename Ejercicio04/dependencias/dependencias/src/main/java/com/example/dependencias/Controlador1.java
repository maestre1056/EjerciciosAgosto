package com.example.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;
    @Autowired
    List<Ciudad> ciudades;
    CiudadService ciudadService;

    @Autowired
    Persona persona1;

    @GetMapping("/Controlador1/addPersona")
    public  Persona crearPersona(@RequestHeader String nombre,@RequestHeader int edad,@RequestHeader String poblacion){
        personaService.getPersona().setNombre(nombre);
        personaService.getPersona().setEdad(edad);
        personaService.getPersona().setPoblacion(poblacion);

        return personaService.getPersona();
    }

    @PostMapping("controlador1/addCiudad")
    public Ciudad addCiudad(@RequestHeader String nombre,@RequestHeader int habitantes){
        Ciudad ciudad= new Ciudad();
        ciudad.setNombre(nombre);
        ciudad.setHabitantes(habitantes);
        ciudadService.addCiudad(ciudad);
       // ciudades.add(ciudad);

        return  ciudad;
    }









    /*
    @GetMapping("{name}")
    public  String holaSimple(){
        return "Hola ";
    }

    @PutMapping
    public Persona getPersona()
    {
        return personaService.getPersona();
    }

    @PostMapping
    public Persona holaPost(@RequestBody Persona persona){
        persona.setComentario("Hola mundo post: "+ persona.getNombre());
        return  persona;
    }
    */


}
