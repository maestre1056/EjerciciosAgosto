package com.example.ej7.crudvalidation.exception;

import lombok.Data;

import java.util.Date;

@Data
public class UnprocessableEntityException extends Exception{
    Date timeStamp;
    int httpCode;

    public UnprocessableEntityException(String message,int httpCode){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);
    }
}
