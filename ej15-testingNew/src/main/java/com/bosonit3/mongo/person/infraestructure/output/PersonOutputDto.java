package com.bosonit3.mongo.person.infraestructure.output;

import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDto {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;
}
