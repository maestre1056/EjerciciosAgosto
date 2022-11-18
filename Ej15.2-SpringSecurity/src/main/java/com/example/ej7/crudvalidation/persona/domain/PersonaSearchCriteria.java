package com.example.ej7.crudvalidation.persona.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonaSearchCriteria {

    private String username;
    private String name;
    private String surname;
    private Date createdDate;
    private String dateCriteria;

}
