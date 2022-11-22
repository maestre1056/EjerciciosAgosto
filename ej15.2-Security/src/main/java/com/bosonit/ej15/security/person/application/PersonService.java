package com.bosonit.ej15.security.person.application;

import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.person.infraestructure.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    Person addPerson(PersonDTO personDTO);
    List<Person> getAllPersons();
    Person getPersonById(Long idPerson) throws Exception;
    Person getPersonByUsername(String username);
    Person updatePerson(Long idPerson, PersonDTO personDTO);
    void deletePerson(Long idPerson);
}
