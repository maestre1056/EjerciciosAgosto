package com.bosonit.ejchuchi.crud.cliente.infraestructure;

import com.bosonit.ejchuchi.crud.cliente.domain.Cliente;
import lombok.Data;

@Data
public class ClienteInputDto {
    private String nombre;

    public Cliente transformIntoCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre(this.nombre);

        return cliente;
    }
}
