package com.bosonit.backend.client.infrastructure.dto;

import com.bosonit.backend.client.domain.Client;
import lombok.Data;

@Data
public class ClientInputDto {
    private String name;
    private String surname;
    private int age;
    private String email;
    private Integer phoneNumber;




}
