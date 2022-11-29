package com.bosonit.backend.client.domain;

import com.bosonit.backend.client.infrastructure.dto.ClientInputDto;
import com.bosonit.backend.travel.domain.Travel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Long idClient;
    @NotEmpty(message = "Field name never can´t empty")
    private String name;
    @NotEmpty(message = "Field surname never can´t empty")
    private String surname;
   // @NotEmpty(message = "Field age never can´t empty")
    private int age;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    private Travel travel;
   // @NotEmpty(message = "Field phone number never can´t empty")
    //@Size(min = 9,max = 9,message = "The length should be 9")
    @Column(unique = true)
    private int phoneNumber;


    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Client(ClientInputDto clientInputDto){
        this.name = clientInputDto.getName();
        this.surname= clientInputDto.getSurname();
        this.age= clientInputDto.getAge();
        this.email= clientInputDto.getEmail();
        this.phoneNumber= clientInputDto.getPhoneNumber();
    }
}
