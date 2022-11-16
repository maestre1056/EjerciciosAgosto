package com.bosonit.ejchuchi.crud.cabecera.infraestructure;

import com.bosonit.ejchuchi.crud.cliente.domain.Cliente;
import com.bosonit.ejchuchi.crud.lineas.infraestructure.LineasOutputDto;
import lombok.Data;

import java.util.List;

@Data
public class FacturaOutputDto {
    private CabeceraOutputDto cabeceraOutputDto;
    private Cliente cliente;
    private List<LineasOutputDto> lineasOutputDto;

}
