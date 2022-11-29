package com.bosonit.backend.client.infrastructure.dto;

import com.bosonit.backend.client.domain.Client;
import lombok.Data;

@Data
public class ClientOutputDto {
    private Long idClient;
    private String name;
    private String surname;
    private int age;
    private String email;
    private int phoneNumber;

    public ClientOutputDto(Client client){
        this.idClient=client.getIdClient();
        this.name= client.getName();
        this.surname= client.getSurname();
        this.age= client.getAge();
        this.email= client.getEmail();
        this.phoneNumber= client.getPhoneNumber();

    }
}
