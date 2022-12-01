package com.bosonit.BackendFrontend.client.domain;

import com.bosonit.BackendFrontend.client.infrastrucutre.ClientOutputDto;
import com.bosonit.BackendFrontend.trip.domain.Travel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long idClient;

    private String name;

    private String lastName;

    private Integer age;

    private String email;

    private Integer phoneNumber;



    public Client(ClientOutputDto client){
        setIdClient(client.getIdClient());
        setName(client.getName());
        setLastName(client.getLastName());
        setAge(client.getAge());
        setEmail(client.getEmail());
        setPhoneNumber(client.getPhoneNumber());
    }
}
