package com.example.ej7.crudvalidation.persona.infraestructure.controller;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.persona.application.PersonaService;
import com.example.ej7.crudvalidation.persona.domain.PersonaPage;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDtoNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PersonaGetController {
    @Autowired
    PersonaService personaService;


    @CrossOrigin(origins = {"*"})
    @GetMapping("/getall")
    public List<PersonaOutputDto> findAll() {
        return personaService.getAll();
    }


    @GetMapping("/persona/{id}")
    public ResponseEntity<PersonaOutputDto> findById(@PathVariable Long id) throws EntityNotFoundException {
        ResponseEntity responseEntity = new ResponseEntity("Hello World!", HttpStatus.INTERNAL_SERVER_ERROR);

        try {
            responseEntity = new ResponseEntity<PersonaOutputDto>(personaService.getById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


    @GetMapping("/persona/username/{username}")
    public ResponseEntity<PersonaOutputDto> findUsername(@PathVariable String username) throws EntityNotFoundException {
        ResponseEntity responseEntity = new ResponseEntity<>("Error interno", HttpStatus.INTERNAL_SERVER_ERROR);
        try {
            responseEntity = new ResponseEntity<PersonaOutputDto>(personaService.getByUsername(username), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @GetMapping("/criteria")
    public ResponseEntity<Page<PersonaOutputDtoNew>> getSearch(PersonaPage personaPage, PersonaSearchCriteria personaSearchCriteria,
                                                               @RequestParam(required = false) String username,
                                                               @RequestParam(required = false) String name,
                                                               @RequestParam(required = false) String surname,
                                                               @RequestParam(required = false) Date createdDate,
                                                               @RequestParam(required = false) String sortBy,
                                                               @RequestParam(required = false) Integer page) throws Exception {

        return new ResponseEntity<>(personaService.getData(personaPage, personaSearchCriteria), HttpStatus.OK);


    }
}
