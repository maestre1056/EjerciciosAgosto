package com.example.ej7.crudvalidation.exception;

import lombok.Data;

import java.util.Date;

@Data
public class CustomeError {
    String message;
    Date timeStamp;
    int httpCode;

    public CustomeError(String message, int httpCode){
        setMessage(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);
    }

}
