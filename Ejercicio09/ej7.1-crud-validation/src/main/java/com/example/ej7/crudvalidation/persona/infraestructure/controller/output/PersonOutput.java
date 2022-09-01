package com.example.ej7.crudvalidation.persona.infraestructure.controller.output;

import com.example.ej7.crudvalidation.persona.domain.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutput {
    private int person_id;
    private String username;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public PersonOutput (Person person){
        this.person_id=person.getId_Person();
        this.username=person.getUsername();
        this.name=person.getName();
        this.surname=person.getSurname();
        this.company_email=person.getCompany_email();
        this.personal_email=person.getPersonal_email();
        this.city=person.getCity();
        this.active= person.getActive();
        this.created_date=person.getCreated_date();
        this.imagen_url=person.getImagen_url();
        this.termination_date=person.getTermination_date();




    }
}
