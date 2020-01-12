package com.poc.framework.exceptions;

import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * <p>Invalid Field Exception</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("serial")
@Getter
public class InvalidFieldException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1072496018977194715L;

	private final transient Object id;
    private final ZonedDateTime zonedDateTime;

    public InvalidFieldException(final Object id,
                final ZonedDateTime zonedDateTime,
                final String message){
        super(message);
        this.id=id;
        this.zonedDateTime=zonedDateTime;
    }
    
}
