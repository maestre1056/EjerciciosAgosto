package com.example.ej7.crudvalidation.estudiante.infraestructure.controller;

import com.example.ej7.crudvalidation.estudiante.application.StudentService;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDeleteController {
    @Autowired
    StudentService studentService;

    @DeleteMapping("/estudiante/{id}")
    public ResponseEntity<String>  deleteStudent(@PathVariable Long id) throws EntityNotFoundException {
        ResponseEntity responseEntity = new ResponseEntity("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
        try {
            responseEntity = new ResponseEntity<String>(studentService.deleteStudent(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
