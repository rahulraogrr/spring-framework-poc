package com.poc.framework.exceptions;

import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
public class ResourceNotFoundException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = -3755354764861619212L;
	
	private final transient Object id;
    private final ZonedDateTime zonedDateTime;

    public ResourceNotFoundException(final Object id,
                   final ZonedDateTime zonedDateTime,final String message){
        super(message);
        this.id=id;
        this.zonedDateTime=zonedDateTime;
    }
}