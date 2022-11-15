package com.bosonit.ejercicio15.testing.person.infraestructure.controller.mapper;

import com.bosonit.ejercicio15.testing.person.domain.Person;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.output.PersonOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper Instance = Mappers.getMapper(PersonMapper.class);

    PersonOutputDto personToPersonOutputDto(Person person);
    Person personInputDtoToPerson(PersonInputDto personInputDto);
}
