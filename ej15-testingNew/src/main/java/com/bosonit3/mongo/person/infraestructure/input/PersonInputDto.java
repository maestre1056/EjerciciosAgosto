package com.bosonit3.mongo.person.infraestructure.input;

import lombok.Data;

import java.util.Date;

@Data
public class PersonInputDto {
        private Long  id;
        private String username;
        private String password;
        private String name;
        private String surname;
        private String companyEmail;
        private String personalEmail;
        private String city;
        private boolean active;
        private Date createdDate;

        public PersonInputDto(Long id, String username, String password, String name, String surname,
                              String companyEmail, String personalEmail, String city,
                              boolean active, Date createdDate) {
                this.id=id;
                this.username = username;
                this.password = password;
                this.name = name;
                this.surname = surname;
                this.companyEmail = companyEmail;
                this.personalEmail = personalEmail;
                this.city = city;
                this.active = active;
                this.createdDate = createdDate;
        }
}

