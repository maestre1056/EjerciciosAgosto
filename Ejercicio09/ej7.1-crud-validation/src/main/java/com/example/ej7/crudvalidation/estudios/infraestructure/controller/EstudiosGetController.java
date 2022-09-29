package com.example.ej7.crudvalidation.estudios.infraestructure.controller;

import com.example.ej7.crudvalidation.estudios.application.EstudiosService;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.output.EstudiosOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudiosGetController {
    @Autowired
    EstudiosService estudiosService;

    @GetMapping("/asignatura/{id}")
    public EstudiosOutputDto getById(@PathVariable Long id){
        return estudiosService.findEstudiosById(id);
    }
}
