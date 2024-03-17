package com.harsh.coderhack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harsh.coderhack.dto.ExceptionApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ExceptionApiResponse apiResponse = new ExceptionApiResponse(message);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionApiResponse> runtimeExceptionHandler(RuntimeException ex){
        String message = ex.getMessage();
        ExceptionApiResponse apiResponse = new ExceptionApiResponse(message);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    
}
