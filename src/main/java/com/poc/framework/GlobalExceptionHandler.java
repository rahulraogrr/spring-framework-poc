package com.poc.framework;

import com.poc.framework.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleException(
            final ResourceNotFoundException e,
            final HttpServletRequest request){
           return new ResponseEntity<>(new ApiErrorResponse(
                   e.getId(),
                   e.getZonedDateTime(),
                   request.getRequestURI(),
                   e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(
            final Exception e,
            final HttpServletRequest request){
        return new ResponseEntity<>(new ApiErrorResponse(
                "",
                ZonedDateTime.now(),
                request.getRequestURI(),
                e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}