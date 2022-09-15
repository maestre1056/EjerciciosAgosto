package com.example.ej7.crudvalidation.estudiante.application;

import com.example.ej7.crudvalidation.estudiante.domain.Estudiante;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.EstudianteInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.EstudianteOutputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.repository.EstudianteRepository;
import com.example.ej7.crudvalidation.persona.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstudianteServiceImp implements EstudianteService{
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public EstudianteOutputDto addEstudiante(EstudianteInputDto newEstudianteDto) throws Exception {

    return null;
    }

    @Override
    public EstudianteOutputDto findEstudianteById(String id) throws Exception {
        return null;
    }

    @Override
    public List<EstudianteOutputDto> getAllPeople() {
        return null;
    }

    @Override
    public EstudianteOutputDto updateEstudiante(String id, EstudianteInputDto estudianteInputDto) throws Exception {
        return null;
    }

    @Override
    public String deleteEstudiante(String id) throws Exception {
        return null;
    }
}
