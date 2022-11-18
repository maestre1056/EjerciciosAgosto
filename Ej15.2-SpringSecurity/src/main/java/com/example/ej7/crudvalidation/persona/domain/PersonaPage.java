package com.example.ej7.crudvalidation.persona.domain;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PersonaPage {

//    private int pageNumber=0;
//    private int pageSize = 10;
//    private Sort.Direction sortDirection = Sort.Direction.ASC;
//    private String sortBy = "name";
//
//    public PersonaPage(int pageNumber , String sortBy){
//        this.pageNumber = pageNumber;
//
//        if(sortBy != null)
//            if(sortBy.equals("username"))
//                this.sortBy = "username";
//    }

    private int pageNumber = 0;
    private int pageSize = 5;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "idPersona";


}
