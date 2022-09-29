package com.example.ej7.crudvalidation.profesor.infraestructure.controller;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.profesor.application.ProfesorService;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesorPutController {
    @Autowired
    ProfesorService profesorService;

    @PutMapping("/profesor/{id}")
    public ResponseEntity<ProfesorOutputDto> updateProfesor(@PathVariable Long id, @RequestBody ProfesorInputDto profesorInputDto)
    throws EntityNotFoundException {
        ResponseEntity responseEntity=new ResponseEntity("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

        try{
            responseEntity=new ResponseEntity<ProfesorOutputDto>(profesorService.updateProfesor(profesorInputDto,id),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return  responseEntity;
    }

}
