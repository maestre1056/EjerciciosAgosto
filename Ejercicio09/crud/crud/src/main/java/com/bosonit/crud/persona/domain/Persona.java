package com.bosonit.crud.persona.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Persona {
    private String nombre;
    private Integer edad;
    private String poblacion;
}
