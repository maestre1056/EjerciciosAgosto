package com.example.ej7.crudvalidation.profesor.infraestructure.controller.input;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputIdDto;
import lombok.Data;

@Data
public class ProfesorInputDto {
    private PersonaInputIdDto persona;
    private String comments;
    private String branch;
}
