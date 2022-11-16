package com.bosonit.ejchuchi.crud.cabecera.infraestructure;

import com.bosonit.ejchuchi.crud.cliente.domain.Cliente;
import com.bosonit.ejchuchi.crud.lineas.infraestructure.LineasOutputDto;
import lombok.Data;

import java.util.List;

@Data
public class CabeceraOutputDto {
    private Integer id_cabecera;
    private Double importeFra;
    private Cliente cliente;
    private List<LineasOutputDto> lineasOutputDto;
}
