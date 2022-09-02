package com.example.ej7.crudvalidation.persona.application;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.domain.Person;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonInput;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonOutput;
import com.example.ej7.crudvalidation.persona.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutput addPerson(PersonInput newPersonDto) throws Exception {
        newPersonDto.setCreated_date(new Date());

        if(newPersonDto.getUsername()==null)
            throw new UnprocessableEntityException("User field can not be null",422);
         if (newPersonDto.getUsername().length()>10||newPersonDto.getUsername().length()<6)
            throw new UnprocessableEntityException("User field length is not between 6 and 10",422);
         if (newPersonDto.getPassword()==null)
            throw  new UnprocessableEntityException("Password can not be null",422);
         if (newPersonDto.getName()==null)
            throw new UnprocessableEntityException("Name can not be null",422);
         if (newPersonDto.getCompany_email()==null)
            throw  new UnprocessableEntityException("Company email can not be null",422);
         if (newPersonDto.getPersonal_email()==null)
            throw new UnprocessableEntityException("Personal email can not be null",422);
         if (newPersonDto.getCity()==null)
             throw new UnprocessableEntityException("City can not be null",422);
         if (newPersonDto.getCreated_date() ==null)
            throw new UnprocessableEntityException("City can not be null",422);

        Person newPerson=newPersonDto.transformIntoPerson();

        System.out.println("newPersonDto = " + newPersonDto);
        System.out.println("newPerson = " + newPerson);

        personRepository.save(newPerson);

        return new PersonOutput(newPerson);
    }




    @Override
    public PersonOutput findPersonById(int id) throws Exception {
        Optional<Person> personOptional=personRepository.findById(id);

        if(personOptional.isEmpty())
            throw new EntityNotFoundException("Person does not exist");
        return new PersonOutput(personOptional.get());
    }

    @Override
    public List<PersonOutput> findPersonByUserName(String username) throws Exception {
        List<Person> peopleList=personRepository.findByUsername(username);
        //if(peopleList.isEmpty())
           // throw new EntityNotFoundException("Person does not exist");
        return peopleList.stream().map(person->new PersonOutput(person)).collect(Collectors.toList());
    }

    @Override
    public List<PersonOutput> getAllPeople() {
        List<Person> peopleList=personRepository.findAll();
        List<PersonOutput> peopleOutputDto=new ArrayList<>();
        peopleOutputDto=peopleList.stream().map(person -> new PersonOutput(person)).collect(Collectors.toList());
        return peopleOutputDto;
    }

    @Override
    public PersonOutput updatePerson(int id, PersonInput personInput) throws Exception {
        personInput.setCreated_date(new Date());
        Optional<Person> personOpt = personRepository.findById(id);

        if(personOpt.isEmpty())
            throw new com.example.ej7.crudvalidation.exception.EntityNotFoundException("Person is not be null",404);
        if(personInput.getUsername() == null)
            throw new Exception("User field can not be null");
        if(personInput.getUsername().length() > 10 || personInput.getUsername().length() < 6)
            throw new Exception("User field length is not between 6 and 10");
        if(personInput.getPassword() == null)
            throw new Exception("Password can not be null");
        if(personInput.getName() == null)
            throw new Exception("Name can not be null");
        if(personInput.getCompany_email() == null)
            throw new Exception("Company email is not null");
        if(!personInput.getCompany_email().contains("@"))
            throw new Exception("Email format is not correct");
        if(personInput.getPersonal_email() == null)
            throw new Exception("Company email is not null");
        if(!personInput.getPersonal_email().contains("@"))
            throw new Exception("Email format is not correct");
        if(personInput.getCity() == null)
            throw new Exception("City can not be null");
        if(personInput.getCreated_date() == null)
            throw new Exception("Created date can not be null");

        Person person = personOpt.get();

        person.setUsername(personInput.getUsername());
        person.setPassword(personInput.getPassword());
        person.setName(personInput.getName());
        person.setSurname(personInput.getSurname());
        person.setCompany_email(personInput.getCompany_email());
        person.setPersonal_email(personInput.getCompany_email());
        person.setCity(personInput.getCity());
        person.setActive(personInput.getActive());
        person.setImagen_url(personInput.getImagen_url());

        personRepository.save(person);

        return new PersonOutput(person);
    }

    @Override
    public String deletePerson(int id) throws Exception {
        Optional<Person>personOpt=personRepository.findById(id);

        if(personOpt.isEmpty())
            throw  new EntityNotFoundException("The person does not exist");
        personRepository.delete(personOpt.get());
        return "La persona ha sido borrada con exito";
    }
}
