package com.example.ej7.crudvalidation.profesor.infraestructure.controller;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.profesor.application.ProfesorService;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfesorGetController {
    @Autowired
    ProfesorService profesorService;

    @GetMapping("/profesor")
    public List<ProfesorOutputDto> getAll() {
        return profesorService.getAll();
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<ProfesorOutputDto> getById(@PathVariable Long id) throws EntityNotFoundException {
        ResponseEntity responseEntity = new ResponseEntity("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);

        try {
                responseEntity=new ResponseEntity<ProfesorOutputDto>(profesorService.getById(id),HttpStatus.OK);
        } catch (EntityNotFoundException e) {
                responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
            return responseEntity;
    }
}

