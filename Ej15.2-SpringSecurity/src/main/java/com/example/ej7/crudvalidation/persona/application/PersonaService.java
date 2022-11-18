package com.example.ej7.crudvalidation.persona.application;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.domain.PersonaPage;
import com.example.ej7.crudvalidation.persona.domain.PersonaSearchCriteria;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDtoNew;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaDto) throws UnprocessableEntityException;

    List<PersonaOutputDto> getAll();

    PersonaOutputDto getById(Long idPersona);

    PersonaOutputDto getByUsername(String username);

    String delete(Long idPersona);

    PersonaOutputDto updatePersona(Long idPersona, PersonaInputDto personaInputDto)throws EntityNotFoundException, UnprocessableEntityException;

    Optional<Persona> getPersonaOptional(Long idPersona);

    Page<PersonaOutputDtoNew> getData(PersonaPage page, PersonaSearchCriteria personaSearchCriteria);
}
