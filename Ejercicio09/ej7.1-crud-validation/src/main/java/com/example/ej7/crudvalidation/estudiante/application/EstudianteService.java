package com.example.ej7.crudvalidation.estudiante.application;

import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.EstudianteInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.EstudianteOutputDto;

import java.util.List;

public interface EstudianteService {
    public EstudianteOutputDto addEstudiante(EstudianteInputDto newEstudianteDto)throws Exception;
    public EstudianteOutputDto findEstudianteById(String id)throws Exception;
    public List<EstudianteOutputDto> getAllPeople();
    public EstudianteOutputDto updateEstudiante(String id,EstudianteInputDto estudianteInputDto)throws Exception;
    public String deleteEstudiante(String id)throws Exception;
}
