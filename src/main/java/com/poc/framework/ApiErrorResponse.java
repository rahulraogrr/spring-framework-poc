package com.poc.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {
    private final Object id;
    private final ZonedDateTime zonedDateTime;
    private final String calledURI;
    private final String message;
}
