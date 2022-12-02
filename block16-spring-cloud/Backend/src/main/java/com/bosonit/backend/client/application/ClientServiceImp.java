package com.bosonit.backend.client.application;

import com.bosonit.backend.client.domain.Client;
import com.bosonit.backend.client.infrastructure.dto.ClientInputDto;
import com.bosonit.backend.client.infrastructure.dto.ClientOutputDto;
import com.bosonit.backend.client.infrastructure.repository.ClientRepository;
import com.bosonit.backend.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientOutputDto addClient(ClientInputDto clientInputDto) {
        Client client = new Client(clientInputDto);
        clientRepository.save(client);

        return new ClientOutputDto(client);
    }

    @Override
    public ClientOutputDto getById(Long id) throws EntityNotFoundException {
        Optional<Client> client = clientRepository.findById(id);
       if(client.isEmpty())
            throw  new EntityNotFoundException("Client does not exist",404);
        return new ClientOutputDto(client.get());

    }

    @Override
    public List<ClientOutputDto> getAll() {

        return clientRepository.findAll().stream().map(ClientOutputDto::new).toList();
    }

    @Override
    public ClientOutputDto updateCliente(Long id,ClientInputDto clientInputDto) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty())
            throw new EntityNotFoundException("Client does not exist",404);
        Client client1 = client.get();
        client1.setName(clientInputDto.getName());
        client1.setSurname(clientInputDto.getSurname());
        client1.setAge(clientInputDto.getAge());
        client1.setEmail(clientInputDto.getEmail());
        client1.setPhoneNumber(clientInputDto.getPhoneNumber());

        clientRepository.save(client1);

        return new ClientOutputDto(client1);
    }

    @Override
    public String deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty())
            throw new EntityNotFoundException("Client does not exist",404);

        clientRepository.deleteById(id);
        return "Client deleted";
    }
}
