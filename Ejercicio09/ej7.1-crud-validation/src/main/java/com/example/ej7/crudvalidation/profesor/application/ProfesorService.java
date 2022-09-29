package com.example.ej7.crudvalidation.profesor.application;


import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
     String addProfesor(ProfesorInputDto profesorInputDto);

     List<ProfesorOutputDto> getAll();

     ProfesorOutputDto getById(Long idProfesor)throws EntityNotFoundException;

     String deleteById(Long idProfesor)throws EntityNotFoundException;

     ProfesorOutputDto updateProfesor(ProfesorInputDto profesorInputDto,Long idProfesor)throws EntityNotFoundException;

     Optional<Profesor> getProfesorOptionalByPersona(Persona persona);

     Optional<Profesor> getProfesorOptional(Long idProfesor);

}
