package com.bosonit.ej15.security.person.application;

import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.person.infraestructure.dto.PersonDTO;
import com.bosonit.ej15.security.person.infraestructure.repository.PersonRepository;
import com.bosonit.ej15.security.security.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Component
@Transactional
@Slf4j
public class PersonServiceImp implements PersonService {
   @Autowired
   PersonRepository personRepository;

    @Override
    public Person addPerson(PersonDTO personDTO) {

        personDTO.setPassword(new BCryptPasswordEncoder().encode(personDTO.getPassword()));
        return personRepository.save(new Person(personDTO));

    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> personList = personRepository.findAll();
        for(Person person:personList){
            person.setPassword(null);
        }
        return personList;
    }

    @Override
    public Person getPersonById(Long idPerson) {
        return personRepository.findById(idPerson).orElseThrow();
    }

    @Override
    public Optional<Person> getPersonByUsername(String username)throws Exception {
        return personRepository.findByUsername(username);
    }

    @Override
    public Person updatePerson(Long idPerson, PersonDTO personDTO) {
        Person personFound = personRepository.findById(idPerson).orElseThrow();

        if (personDTO.getUsername() != null) {
            personFound.setUsername(personDTO.getUsername());
        }
        if (personDTO.getPassword() != null) {
           // personDTO.setPassword(passwordEncoder.encode(personDTO.getPassword()));
            personFound.setPassword(personDTO.getPassword());
        }
        if (personDTO.getName() != null) {
            personFound.setName(personDTO.getName());
        }
        if (personDTO.getSurname() != null) {
            personFound.setSurname(personDTO.getSurname());
        }
        if (personDTO.getAge() != null) {
            personFound.setAge(personDTO.getAge());
        }
        if (personDTO.getRoles() != null) {
            personFound.setRoles(personDTO.getRoles());
        }

        return personRepository.save(personFound);
    }

    @Override
    public void deletePerson(Long idPerson) {
        personRepository.deleteById(idPerson);
    }

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository
                .findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario con username "+username+" no existe"));
        return new UserDetailsImpl(person);
    }

    */
}
