package com.bosonit.ejchuchi.crud.cabecera.infraestructure;

import com.bosonit.ejchuchi.crud.cabecera.domain.Cabecera;
import lombok.Data;

@Data
public class CabeceraInputDto {
    private Integer id_cabecera;
    private double importeFra;

    public Cabecera transformIntoCabecera(){
        Cabecera cabecera= new Cabecera();
        setImporteFra(this.importeFra);

        return cabecera;
    }

}
