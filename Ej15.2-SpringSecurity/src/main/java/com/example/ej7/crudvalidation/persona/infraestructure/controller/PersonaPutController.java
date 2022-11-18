package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.application.PersonaService;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaPutController {
    @Autowired
    PersonaService personaService;

    @PutMapping("/persona/{id}")
    public ResponseEntity <PersonaOutputDto> updatePersona(@PathVariable Long id, @RequestBody PersonaInputDto personaInputDto){
       ResponseEntity responseEntity=new ResponseEntity("Hello World!", HttpStatus.INTERNAL_SERVER_ERROR);
       try {
           responseEntity = new ResponseEntity<PersonaOutputDto>(personaService.updatePersona(id,personaInputDto), HttpStatus.OK);
       }catch (EntityNotFoundException e){
           responseEntity=new ResponseEntity<>(e.getMessage()+"-"+e.getTimeStamp(),HttpStatus.NOT_FOUND);
       } catch (UnprocessableEntityException e){
           responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
       }
        return responseEntity;
    }


}
