package com.example.ej7.crudvalidation.persona.application;

import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonInput;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonOutput;

import java.util.List;

public interface PersonService {

    public PersonOutput addPerson(PersonInput newPersonDto) throws Exception;

    public PersonOutput findPersonById(int id) throws  Exception;

    public List<PersonOutput> findPersonByUserName(String username) throws Exception;

    public List<PersonOutput> getAllPeople();

    public PersonOutput updatePerson(int id,PersonInput personInput) throws  Exception;

    public String deletePerson(int id) throws  Exception;
}
