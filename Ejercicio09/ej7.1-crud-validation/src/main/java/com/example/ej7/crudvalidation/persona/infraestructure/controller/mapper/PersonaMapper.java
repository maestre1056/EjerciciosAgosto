package com.example.ej7.crudvalidation.persona.infraestructure.controller.mapper;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper Instance = Mappers.getMapper(PersonaMapper.class);

    PersonaOutputDto personaToPersonaOutputDto(Persona persona);
    Persona personaInputDtoToPersona(PersonaInputDto personaInputDto);
}
