package com.example.ej7.crudvalidation.estudios.application;

import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.output.EstudiosOutputDto;

public interface EstudiosService {

    public EstudiosOutputDto addEstudios(EstudiosInputDto estudiosInputDto);

    public EstudiosOutputDto updateEstudios(Long idEstudios, EstudiosInputDto estudiosInputDto);


    public EstudiosOutputDto findEstudiosById(Long idEstudios);

    public String deleteEstudios(Long id);
}
