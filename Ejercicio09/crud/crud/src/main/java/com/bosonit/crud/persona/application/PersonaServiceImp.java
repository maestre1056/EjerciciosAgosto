package com.bosonit.crud.persona.application;

import com.bosonit.crud.persona.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonaServiceImp implements PersonaService {
    List<Persona> personaList=new ArrayList<>();
    @Override
    public void addPersona(Persona persona) {
        personaList.add(persona);

    }

    @Override
    public Persona findById(int id) {
       Persona p2= personaList.get(id);
        return p2;
    }

    @Override
    public List<Persona> findByName(String name) {
     /*   for(Persona person:personaList) {
            if (person.getNombre().equals(name))
                return person;
        }

      */
        List<Persona> p1=new ArrayList<>();
        p1=personaList.stream().filter((p)->p.getNombre().equals(name)).toList();
        return p1;
    }

    @Override
    public Persona update(Long id,Persona persona) {
        if(persona.getNombre()!=null) {
            personaList.get(id.intValue()).setNombre(persona.getNombre());
        }
        if(persona.getEdad()!=null){
            personaList.get(id.intValue()).setEdad(persona.getEdad());
        }
        if(persona.getPoblacion()!=null){
            personaList.get(id.intValue()).setPoblacion(persona.getPoblacion());
        }
        return null;
    }

    @Override
    public Persona delete(Long id) {
        return personaList.remove(id.intValue());
    }

    public List<Persona> listarLista(){
        return personaList;
    }
}
