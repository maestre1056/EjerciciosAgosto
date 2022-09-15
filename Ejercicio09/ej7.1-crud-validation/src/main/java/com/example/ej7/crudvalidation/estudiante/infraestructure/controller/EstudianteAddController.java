package com.example.ej7.crudvalidation.estudiante.infraestructure.controller;

import com.example.ej7.crudvalidation.estudiante.application.EstudianteServiceImp;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.EstudianteInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.EstudianteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudianteAddController {
    @Autowired
    EstudianteServiceImp estudianteServiceImp;

    @PostMapping("/estudiante")
    public EstudianteOutputDto addEstudiante(@RequestBody  EstudianteInputDto estudianteInputDto)throws Exception{
        return estudianteServiceImp.addEstudiante(estudianteInputDto);
    }
}
