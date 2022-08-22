package com.example.dependencias;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Persona {
    String nombre;
    int edad;
    String poblacion;
}
