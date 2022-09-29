package com.example.ej7.crudvalidation.profesor.infraestructure.controller.output;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import lombok.Data;

@Data
public class ProfesorOutputDto {
    private Long idProfesor;
    private PersonaOutputDto persona;
    private String comments;
    private String branch;
}
