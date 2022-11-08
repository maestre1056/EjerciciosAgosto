package com.bosonit.nuevoMongo4.person.exception;

import lombok.Data;

import java.util.Date;
@Data
public class UnprocessableEntityException  extends RuntimeException{
    Date timeStamp;
    int httpCode;

    public UnprocessableEntityException(String message,int httpCode){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);


    }
}
