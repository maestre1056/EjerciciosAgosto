package com.bosonit.backend.client.application;

import com.bosonit.backend.client.infrastructure.dto.ClientInputDto;
import com.bosonit.backend.client.infrastructure.dto.ClientOutputDto;

import java.util.List;

public interface ClientService {
    ClientOutputDto addClient(ClientInputDto clientInputDto);

    ClientOutputDto getById(Long id);

    List<ClientOutputDto> getAll();

    ClientOutputDto updateCliente(Long id, ClientInputDto clientInputDto);

    String deleteClient(Long id);


}
