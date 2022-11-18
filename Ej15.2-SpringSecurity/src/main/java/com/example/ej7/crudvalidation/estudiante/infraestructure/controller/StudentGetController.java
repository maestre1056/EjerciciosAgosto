package com.example.ej7.crudvalidation.estudiante.infraestructure.controller;

import com.example.ej7.crudvalidation.estudiante.infraestructure.application.StudentService;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentGetController {

    @Autowired
    StudentService studentService;

    @GetMapping("/estudiante/list")
    public List<StudentOutputDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/estudiante/id/{id}")
    public ResponseEntity<StudentOutputDto> getById(@PathVariable Long id)throws EntityNotFoundException {
        ResponseEntity responseEntity= new ResponseEntity<>("Error interno", HttpStatus.INTERNAL_SERVER_ERROR);
        try{
            responseEntity=new ResponseEntity<StudentOutputDto>(studentService.getById(id),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;

    }

}
