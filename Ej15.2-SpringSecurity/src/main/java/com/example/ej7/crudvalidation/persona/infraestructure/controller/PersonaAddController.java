package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.application.PersonaService;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaAddController {
    @Autowired
    PersonaService personaService;

    @CrossOrigin(origins = {"*"})
    @PostMapping("/addperson")
    public ResponseEntity<PersonaOutputDto>  addPersona(@RequestBody PersonaInputDto personaInputDto) throws UnprocessableEntityException {
        ResponseEntity responseEntity=new ResponseEntity<>("Error interno", HttpStatus.INTERNAL_SERVER_ERROR);

        try {
            responseEntity=new ResponseEntity<PersonaOutputDto>(personaService.addPersona(personaInputDto),HttpStatus.OK);
        }catch (UnprocessableEntityException e){

            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return responseEntity;
    }


}
