package com.example.ej7.crudvalidation.profesor.infraestructure.controller;

import com.example.ej7.crudvalidation.profesor.application.ProfesorService;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesorAddController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/profesor")
    public String addProfesor(@RequestBody ProfesorInputDto profesorInputDto){
        return profesorService.addProfesor(profesorInputDto);
    }
}
