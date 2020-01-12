package com.poc.framework.exceptions;

import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * <p>Resource Not Found Exception</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
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