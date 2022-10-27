package com.bosonit3.mongo.person.application;

import com.bosonit3.mongo.person.domain.Person;
import com.bosonit3.mongo.person.exception.UnprocessableEntityException;

import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.mapper.PersonMapper;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import com.bosonit3.mongo.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImp implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        personInputDto.setCreatedDate(new Date());
        if(personInputDto.getName()==null)
            throw new UnprocessableEntityException("Campo nulo",422);
        if(personInputDto.getUsername()==null)
            throw new UnprocessableEntityException("Campo username nulo",422);
        if(personInputDto.getSurname()==null)
            throw new UnprocessableEntityException("Campo surname nulo",422);
        if(personInputDto.getCity()==null)
            throw new UnprocessableEntityException("Campo city nulo",422);
        Person personEntity= PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        personRepository.save(personEntity);
        return PersonMapper.Instance.personToPersonOutputDto(personEntity);
    }

    @Override
    public PersonOutputDto findById(String id) {
        return null;
    }

    @Override
    public Page<PersonOutputDto> getAll(Integer page) {
        return null;
    }

    @Override
    public List<PersonOutputDto> findPeopleByUsername(String username) {
       List<Person> personList = personRepository.findByUsername(username);
       List<PersonOutputDto> p1 =new ArrayList<>();
       for(Person person:personList) {
           if(person.getUsername().equals(username)){
            PersonOutputDto personOutputDto=PersonMapper.Instance.personToPersonOutputDto(person);
            p1.add(personOutputDto);
           }

       }
        return p1;
    }

    @Override
    public String deletePerson(String id) {
        return null;
    }

    @Override
    public PersonOutputDto update(String id) {
        return null;
    }
}