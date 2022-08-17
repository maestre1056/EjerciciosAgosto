package com.example.SpringFirst;


import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerPersona {

    @GetMapping("user/{name}")
        public String getting(@PathVariable String name){
            return name;
        }


    @PostMapping("userAdd")
    public Persona add(@RequestBody Persona persona){
        persona.setEdad(persona.getEdad()+1);
        return persona;
    }


}
