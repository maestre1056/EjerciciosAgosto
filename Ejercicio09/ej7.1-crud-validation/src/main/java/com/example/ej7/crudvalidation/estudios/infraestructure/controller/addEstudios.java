package com.example.ej7.crudvalidation.estudios.infraestructure.controller;

import com.example.ej7.crudvalidation.estudios.application.EstudiosService;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.output.EstudiosOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addEstudios {
    @Autowired
    EstudiosService estudiosService;

    @PostMapping("/asignatura")
    public EstudiosOutputDto addEstudio(@RequestBody EstudiosInputDto estudiosInputDto){
        return estudiosService.addEstudios(estudiosInputDto);
    }
}
