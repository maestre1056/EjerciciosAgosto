package com.bosonit3.mongo.person.infraestructure.mapper;

import com.bosonit3.mongo.person.domain.Person;

import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper Instance = Mappers.getMapper(PersonMapper.class);

    PersonOutputDto personToPersonOutputDto(Person person);
    Person personInputDtoToPerson(PersonInputDto personInputDto);
}
