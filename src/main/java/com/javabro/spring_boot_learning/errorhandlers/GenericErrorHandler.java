package com.javabro.spring_boot_learning.errorhandlers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GenericErrorHandler {

    @ExceptionHandler(exception = RuntimeException.class)
    public ErrorResponse handleRuntimeException() {
        System.out.println("handling runtime exception");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage("something went wrong");
        errorResponse.setErrorDescription("something went wrong please contact administrator");
        errorResponse.setTimestamp(LocalDateTime.now());
        return errorResponse;
    }
}
