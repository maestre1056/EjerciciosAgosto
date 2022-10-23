package com.bosonit3.mongo.person.infraestructure.input;

import lombok.Data;

import java.util.Date;

@Data
public class PersonInputDto {
        private String username;
        private String password;
        private String name;
        private String surname;
        private String companyEmail;
        private String personalEmail;
        private String city;
        private boolean active;
        private Date createdDate;
    }

