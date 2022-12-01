package com.bosonit.BackendFrontend.client.infrastrucutre;

import com.bosonit.BackendFrontend.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientOutputDto {
    private Long idClient;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Integer phoneNumber;


}
