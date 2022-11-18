package com.example.ej7.crudvalidation.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Data
public class UnprocessableEntityException extends RuntimeException {
    Date timeStamp;


    public UnprocessableEntityException(String message){
        super(message);
        setTimeStamp(new Date());
       //setHttpCode(httpCode);
    }

}
