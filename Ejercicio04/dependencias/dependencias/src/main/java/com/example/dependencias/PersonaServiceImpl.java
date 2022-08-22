package com.example.dependencias;


import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    Persona persona=new Persona();
    @Override
    public void addPersona(Persona p) {
        persona=p;
    }


    @Override
    public Persona getPersona() {
        return persona;
    }


}
