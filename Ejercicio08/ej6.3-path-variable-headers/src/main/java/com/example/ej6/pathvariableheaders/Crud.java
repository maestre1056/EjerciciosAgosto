package com.example.ej6.pathvariableheaders;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Crud {
   private List<Greeting1> personas=new ArrayList<>();

   public List<Greeting1> getPersonList(){
      return  personas;
   }
   public void addPersonList(Greeting1 newPerson){
      personas.add(newPerson);
   }

   public void deletePerson(int id){
      personas.remove(id);
   }

   public void modifyPerson(int id,Greeting1 newPerson){
      Greeting1 oldPersona=personas.get(id);
      if(oldPersona==null)
         return;
      Optional <String> newName= Optional.ofNullable(newPerson.getContenido());
     // Optional <Integer> newId= Optional.of(newPerson.getId());

      newPerson.setContenido(newName.isPresent()? newName.get():oldPersona.getContenido());

      if(newPerson.getId()<0)
         newPerson.setId(oldPersona.getId());

      personas.set(id, newPerson);
   }
   public Greeting1 getPersonaByName(String name){
      for(Greeting1 person:personas){
         if(person.getContenido().equals(name)){
            return  person;
         }
      }
      return null;
   }

   public Greeting1 getPersonaById(int id){
      return personas.get(id);
   }


}
