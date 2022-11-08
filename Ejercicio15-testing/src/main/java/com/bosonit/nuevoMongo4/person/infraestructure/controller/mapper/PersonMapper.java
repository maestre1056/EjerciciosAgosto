package com.bosonit.nuevoMongo4.person.infraestructure.controller.mapper;

import com.bosonit.nuevoMongo4.person.domain.Person;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.output.PersonOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper Instance = Mappers.getMapper(PersonMapper.class);

    PersonOutputDto personToPersonOutputDto(Person person);
    Person personInputDtoToPerson(PersonInputDto personInputDto);
}
