package com.example.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador3 {
    @Autowired
    Persona persona1;

    @Autowired
    Persona persona2;

    @Autowired
    Persona persona3;

    @GetMapping("controlador/bean/bean1")
    @Qualifier ("bean1")
    public Persona getPersona1(){
        persona1.setNombre("Antonio");
        persona1.setEdad(28);
        persona1.setPoblacion("Cordoba");
        return  persona1;
    }

    @GetMapping("controlador/bean/bean2")
    @Qualifier ("bean2")
    public Persona getPersona2(){
        persona2.setNombre("Rafa");
        persona2.setEdad(28);
        persona2.setPoblacion("Malaga");
        return  persona2;
    }

    @GetMapping("controlador/bean/bean3")
    @Qualifier ("bean3")
    public Persona getPersona3(){
        persona3.setNombre("Pedro");
        persona3.setEdad(50);
        persona3.setPoblacion("Cordoba");
        return  persona3;
    }


}
