package com.bosonit.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomeError handleEntityNotFoundException(EntityNotFoundException exception){
        return new CustomeError(exception.getMessage(), 404);

    }

    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public CustomeError handleUnprocessableEntityException(UnprocessableEntityException exception){
        return new CustomeError(exception.getMessage(), 422);
}
}
