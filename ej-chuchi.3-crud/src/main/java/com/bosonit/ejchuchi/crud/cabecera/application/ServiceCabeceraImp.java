package com.bosonit.ejchuchi.crud.cabecera.application;

import com.bosonit.ejchuchi.crud.cabecera.domain.Cabecera;
import com.bosonit.ejchuchi.crud.cabecera.infraestructure.controller.CabeceraRepository;
import com.bosonit.ejchuchi.crud.lineas.domain.Lineas;
import com.bosonit.ejchuchi.crud.lineas.infraestructure.LineasInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCabeceraImp {
    @Autowired
    CabeceraRepository cabeceraRepository;

    public Cabecera loadLine(LineasInputDto lineasInputDto){
        Optional<Cabecera> factura = cabeceraRepository.findById(lineasInputDto.getId_lineas());
        if (factura.isEmpty()){
            throw new EntityNotFoundException();
        }
        List<Lineas> lineasList = factura.get().getLineas();
        Lineas linea = new Lineas(lineasInputDto.getProNombre(),
                lineasInputDto.getCantidad(),
                lineasInputDto.getPrecio());
        lineasList.add(linea);
        factura.get().setLineas(lineasList);

        return cabeceraRepository.save(factura.get());
    }

    public String delete(Integer id) throws Exception{
        Cabecera cabecera = cabeceraRepository.findById(id).orElseThrow();
        cabeceraRepository.delete(cabecera);
        return "Factura borrada";
    }

    public List<Cabecera> getAll(){
        return Streamable.of(cabeceraRepository.findAll()).toList();
    }
}
