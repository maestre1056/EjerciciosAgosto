package com.example.ej6.pathvariableheaders;


import lombok.Data;

@Data
public class Greeting1 {
    public int id;
    public String contenido;

    public  Greeting1(int id,String contenido){
        this.id=id;
        this.contenido=contenido;

    }
}
