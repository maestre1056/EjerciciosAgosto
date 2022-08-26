package com.example.ej6.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySource("miconfiguracion.properties")
@RestController
public class LeerConfiguracion {

    @Value("${valor1}")
    private String valor1;

    @Value("${valor2}")
    private String valor2;

    @GetMapping("configuracion")
    public String getConfiguracion(){
        return  valor1 + "\n " + valor2;
    }



}
