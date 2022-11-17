package com.bosonit.ejchuchi.crud.lineas.infraestructure.controller;

import com.bosonit.ejchuchi.crud.cabecera.application.ServiceCabeceraImp;
import com.bosonit.ejchuchi.crud.cabecera.domain.Cabecera;
import com.bosonit.ejchuchi.crud.lineas.infraestructure.LineasInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    ServiceCabeceraImp serviceCabeceraImp;

    @GetMapping("/factura")
    public  List<Cabecera> findAll(){
        return serviceCabeceraImp.getAll();
    }

    @DeleteMapping("/factura/{id}")
    public ResponseEntity<String>  delete(@PathVariable Integer id)throws Exception{
        ResponseEntity responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

        try {
            responseEntity = new ResponseEntity<String>(serviceCabeceraImp.delete(id),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            responseEntity = new ResponseEntity<>("La factura con este id no existe",HttpStatus.NOT_FOUND);
        }
        return responseEntity ;
    }

    @PutMapping("/linea/{id}")
    public Cabecera addLinea(@PathVariable Integer id,
                             @RequestBody LineasInputDto lineasInputDto)
                             throws Exception {
        lineasInputDto.setId_lineas(id);
        return serviceCabeceraImp.loadLine(lineasInputDto);
    }
}
