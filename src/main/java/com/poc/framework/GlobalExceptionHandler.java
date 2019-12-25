package com.poc.framework;

import com.poc.framework.exceptions.InvalidFieldException;
import com.poc.framework.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

/**
 * <p>Handles all the exceptions thrown in the application and returns
 * {@link ApiErrorResponse}</p>
 * @author Rahul Rao Gonda
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * <p>Handles {@link ResourceNotFoundException} Exception</p>
     * @param e {@link ResourceNotFoundException}
     * @param request {@link HttpServletRequest}
     * @return {@link ApiErrorResponse}
     *
     * @see ResourceNotFoundException
     * @since 1.0.0
     */
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

    /**
     * <p>Handles {@link InvalidFieldException} Exception</p>
     * @param e {@link InvalidFieldException}
     * @param request {@link HttpServletRequest}
     * @return {@link ApiErrorResponse}
     *
     * @see InvalidFieldException
     * @since 1.0.0
     */
    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<ApiErrorResponse> handleException(
            final InvalidFieldException e,
            final HttpServletRequest request
    ){
        return new ResponseEntity<>(new ApiErrorResponse(
                e.getId(),
                e.getZonedDateTime(),
                request.getRequestURI(),
                e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * <p>Handles any {@link Exception}</p>
     * @param e {@link Exception}
     * @param request {@link HttpServletRequest}
     * @return {@link ApiErrorResponse}
     *
     * @since 1.0.0
     */
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