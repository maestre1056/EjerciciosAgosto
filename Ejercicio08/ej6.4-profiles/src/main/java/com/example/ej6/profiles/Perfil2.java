package com.example.ej6.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("perfil2")
@Component
public class Perfil2 implements Perfiles {
    @Override
    public String mifuncion() {
        return "Hola perfil2";
    }
}
