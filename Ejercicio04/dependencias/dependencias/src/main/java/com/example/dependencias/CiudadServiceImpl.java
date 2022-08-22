package com.example.dependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl  implements CiudadService {

    List <Ciudad> ciudades= new ArrayList<>();
    @Autowired
    //List<Ciudad> ciudades;

    @Override
    public void addCiudad(Ciudad c) {
        ciudades.add(c);
    }

    @Override
    public List<Ciudad> getCiudad() {
        return ciudades;
    }
}
