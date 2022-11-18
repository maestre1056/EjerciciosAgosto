package com.example.ej7.crudvalidation.estudios.infraestructure.controller;

import com.example.ej7.crudvalidation.estudios.application.EstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudiosDeleteController {
    @Autowired
    EstudiosService estudiosService;

    @DeleteMapping("/asignatura/{id}")
    public String deleteEstudios(@PathVariable Long idEstudios){
        return estudiosService.deleteEstudios(idEstudios);
    }

}
