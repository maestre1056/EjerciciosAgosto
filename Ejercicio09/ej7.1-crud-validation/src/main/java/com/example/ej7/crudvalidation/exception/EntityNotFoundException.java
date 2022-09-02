package com.example.ej7.crudvalidation.exception;

import lombok.Data;

import java.util.Date;
@Data
public class EntityNotFoundException extends Exception{
    Date timeStamp;
    int httpCode;

    public EntityNotFoundException(String message,int httpCode){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);

    }


}
