package com.example.ej7.crudvalidation.estudiante.infraestructure.controller;

import com.example.ej7.crudvalidation.estudiante.application.StudentService;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentPutController {

    @Autowired
    StudentService studentService;

    @PutMapping("/estudiante/{id}")
    public ResponseEntity<StudentOutputDto> updateStudent(@PathVariable Long id, @RequestBody StudentInputDto studentInputDto)
    throws EntityNotFoundException {
        ResponseEntity responseEntity=new ResponseEntity("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

        try{
            responseEntity=new ResponseEntity<StudentOutputDto>(studentService.updateStudent(studentInputDto, id),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
