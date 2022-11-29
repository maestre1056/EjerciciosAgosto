package com.bosonit.backend.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Data
public class UnprocessableEntityException extends RuntimeException {
    Date timeStamp;
    int httpCode;

    public UnprocessableEntityException(String message,int httpCode){
        super(message);
        setTimeStamp(new Date());
        setHttpCode(httpCode);
    }

}
