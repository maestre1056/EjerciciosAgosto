package com.bosonit.nuevoMongo4.person.exception;

import lombok.Data;

import java.util.Date;

@Data
public class EntityNotFoundException extends RuntimeException{
    Date timeStamp;
    int httpCode;

    public EntityNotFoundException(String message , int httpCode){
        super(message);
        setTimeStamp(new Date());
         setHttpCode(httpCode);

    }
}
