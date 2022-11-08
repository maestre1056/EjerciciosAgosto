package com.bosonit.nuevoMongo4.person.application;

import com.bosonit.nuevoMongo4.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.output.PersonOutputNew;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto personInputDto);

    PersonOutputDto findById(Long id);

    Page<PersonOutputNew> getAll(Integer page);

    List<PersonOutputDto> findPeopleByUsername(String username);

    String deletePerson(Long id);

    PersonOutputDto update(Long id,PersonInputDto personInputDto);
}
