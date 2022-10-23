package com.bosonit3.mongo.person.application;


import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {
    PersonOutputDto addPerson(PersonInputDto personInputDto);

    PersonOutputDto findById(String id);

    Page<PersonOutputDto> getAll(Integer page);

    List<PersonOutputDto> findPeopleByUsername(String username);

    String deletePerson(String id);

    PersonOutputDto update(String id);
}
