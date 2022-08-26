package com.example.ej6.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${url}")
    private String url;

    @Value("${password}")
    private int password;

    @GetMapping("parametros")
    public String getValores(){
        return   url +" /n "+ password;
    }


}
