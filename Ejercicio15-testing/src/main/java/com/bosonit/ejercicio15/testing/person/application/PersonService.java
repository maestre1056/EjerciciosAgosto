package com.bosonit.ejercicio15.testing.person.application;

import com.bosonit.ejercicio15.testing.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.output.PersonOutputNew;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto personInputDto);

    PersonOutputDto findById(Long id);

    Page<PersonOutputNew> getAll(Integer page);

    List<PersonOutputDto> findAll();

    List<PersonOutputDto> findPeopleByUsername(String username);

    String deletePerson(Long id);

    PersonOutputDto update(Long id,PersonInputDto personInputDto);

}
