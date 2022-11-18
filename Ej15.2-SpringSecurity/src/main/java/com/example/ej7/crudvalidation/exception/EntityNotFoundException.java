package com.example.ej7.crudvalidation.exception;

import lombok.Data;

import java.util.Date;

@Data
public class EntityNotFoundException extends RuntimeException{

    Date timeStamp;


    public EntityNotFoundException(String message){
        super(message);
        setTimeStamp(new Date());
       // setHttpCode(httpCode);

    }

}
