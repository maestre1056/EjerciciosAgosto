package com.example.ej7.crudvalidation.estudiante.infraestructure.controller;

import com.example.ej7.crudvalidation.estudiante.infraestructure.application.StudentService;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentAddController {
    @Autowired
    StudentService studentService;

    @PostMapping("/estudiante")
    public String addStudent( @RequestBody StudentInputDto studentInputDto){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA = " + studentInputDto);
        return studentService.addStudent(studentInputDto);
    }
}
