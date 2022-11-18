package com.example.ej7.crudvalidation.profesor.infraestructure.controller;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.profesor.application.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesorDeleteController {
    @Autowired
    ProfesorService profesorService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteProfesor(@PathVariable Long id)throws EntityNotFoundException{
        ResponseEntity responseEntity=new ResponseEntity("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

        try {
            responseEntity=new ResponseEntity<String>(profesorService.deleteById(id),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
