package com.example.ej7.crudvalidation.estudios.infraestructure.controller;

import com.example.ej7.crudvalidation.estudios.application.EstudiosService;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.output.EstudiosOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudiosUpdateController {
    @Autowired
    EstudiosService estudiosService;

    @PutMapping("/asignatura/{id}")
    public EstudiosOutputDto updateEstudios(@PathVariable Long idEstudios, @RequestBody EstudiosInputDto estudiosInputDto){
        return estudiosService.updateEstudios(idEstudios,estudiosInputDto);
    }
}
