package com.bosonit.ejchuchi.crud.lineas.infraestructure;

import com.bosonit.ejchuchi.crud.lineas.domain.Lineas;
import lombok.Data;

@Data
public class LineasInputDto {
    public Integer id_lineas;
    public String proNombre;
    public Double cantidad;
    public Double precio;

    public Lineas transformIntoLineas(){
        Lineas lineas = new Lineas();
        lineas.setProNombre(this.proNombre);
        lineas.setCantidad(this.cantidad);
        lineas.setPrecio(this.precio);

        return lineas;
    }
}
