package com.poc.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class ApiErrorResponse implements Serializable {
	private static final long serialVersionUID = -5648649697771856873L;

	private final transient Object id;
    private final ZonedDateTime zonedDateTime;
    private final String calledURI;
    private final String message;
}