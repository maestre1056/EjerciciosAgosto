package com.bosonit3.mongo.person.exception;

import lombok.Data;

import java.util.Date;

@Data
public class EntityNotFoundException extends RuntimeException{
    Date timeStamp;
    int httpCode;

    public EntityNotFoundException(String message,int httpCode, Date timeStamp){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);

    }


}
