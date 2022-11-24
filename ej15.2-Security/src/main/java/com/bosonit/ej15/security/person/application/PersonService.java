package com.bosonit.ej15.security.person.application;

import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.person.infraestructure.dto.PersonDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person addPerson(PersonDTO personDTO);
    List<Person> getAllPersons();
    Person getPersonById(Long idPerson) throws Exception;
    Optional<Person> getPersonByUsername(String username) throws Exception;
    Person updatePerson(Long idPerson, PersonDTO personDTO);
    void deletePerson(Long idPerson);

   // UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
