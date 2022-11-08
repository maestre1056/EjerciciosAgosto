package com.bosonit.nuevoMongo4.person.application;

import com.bosonit.nuevoMongo4.person.domain.Person;
import com.bosonit.nuevoMongo4.person.exception.EntityNotFoundException;
import com.bosonit.nuevoMongo4.person.exception.UnprocessableEntityException;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.mapper.PersonMapper;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.output.PersonOutputNew;
import com.bosonit.nuevoMongo4.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public PersonOutputDto findById(Long id) {
        Optional<Person> personOptional= personRepository.findById(id);
        if(personOptional.isEmpty())
            throw new EntityNotFoundException("La persona con este id no existe",404);
        Person personEntity=personOptional.get();
        return PersonMapper.Instance.personToPersonOutputDto(personEntity);
    }

    @Override
    public Page<PersonOutputNew> getAll(Integer page) {

        Sort sort = Sort.by(Sort.Direction.ASC, "username");
        Pageable pageable = PageRequest.of(page,3,sort);

        Page<Person> peoplePage= personRepository.findAll(pageable);
        List<PersonOutputNew> personOutputNewList = peoplePage.stream().map(PersonOutputNew::new).collect(Collectors.toList());

        return new PageImpl<>(personOutputNewList,pageable,personOutputNewList.size());



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
    public String deletePerson(Long id) {
        Optional<Person> personOpt= personRepository.findById(id);
        if(personOpt.isEmpty())
            throw new EntityNotFoundException("Este usuario no existe",404);

        personRepository.delete(personOpt.get());

        return "Persona borrada con éxito";
    }

    @Override
    public PersonOutputDto update(Long id,PersonInputDto personInputDto) {
        Optional<Person> personOpt = personRepository.findById(id);
        if(personOpt.isEmpty())
            throw new EntityNotFoundException("El usuario con este id no existe",404);
        if(personInputDto.getName()==null)
            throw new UnprocessableEntityException("Campo nulo",422);
        if(personInputDto.getUsername()==null)
            throw new UnprocessableEntityException("Campo username nulo",422);
        if(personInputDto.getSurname()==null)
            throw new UnprocessableEntityException("Campo surname nulo",422);
        if(personInputDto.getCity()==null)
            throw new UnprocessableEntityException("Campo city nulo",422);

        Person personEntity =personOpt.get();
        personEntity= PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        personEntity.setId(id);
        personEntity= personRepository.save(personEntity);

        return PersonMapper.Instance.personToPersonOutputDto(personEntity);
    }

}
