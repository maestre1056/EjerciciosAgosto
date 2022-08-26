package com.example.ej6.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("perfil1")
@Component
public class Perfil1 implements Perfiles {

    private String perfil1="perfil1";
    @Override
    public String mifuncion() {
        return "Hola" + perfil1;
    }





}
