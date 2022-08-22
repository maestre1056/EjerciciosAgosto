package com.example.dependencias;


import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class Ciudad {
    String nombre;
    int habitantes;
}
