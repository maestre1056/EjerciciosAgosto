package com.bosonit.crud.persona.application;

import com.bosonit.crud.persona.domain.Persona;

import java.util.List;

public interface PersonaService {
    public void addPersona(Persona persona);
    public Persona findById(int id);
    public List<Persona> findByName(String name);
    public Persona update(Long id, Persona persona);
    public Persona delete(Long id);
}
