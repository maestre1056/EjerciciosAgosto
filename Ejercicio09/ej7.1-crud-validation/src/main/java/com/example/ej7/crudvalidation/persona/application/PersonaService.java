package com.example.ej7.crudvalidation.persona.application;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaDto) throws UnprocessableEntityException;

    List<PersonaOutputDto> getAll();

    PersonaOutputDto getById(Long id);

    PersonaOutputDto getByUsername(String username);

    String delete(Long id);

    PersonaOutputDto updatePersona(Long id, PersonaInputDto personaInputDto)throws EntityNotFoundException, UnprocessableEntityException;
}
