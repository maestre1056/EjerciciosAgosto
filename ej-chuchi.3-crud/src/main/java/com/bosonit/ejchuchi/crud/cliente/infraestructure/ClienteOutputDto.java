package com.bosonit.ejchuchi.crud.cliente.infraestructure;

import lombok.Data;

@Data
public class ClienteOutputDto {
    private Integer id_cliente;
    private String nombre;

    public ClienteOutputDto(Integer id_cliente, String nombre) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
    }
}
