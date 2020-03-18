package com.poc.utils;

import com.poc.constants.MessageConstants;
import com.poc.framework.exceptions.ResourceNotFoundException;

import java.time.ZonedDateTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Rahul Rao Gonda
 * @version 1.0.0
 */
public class ExceptionUtil {

    public static final Consumer throwResourceNotFoundException = id -> {
        throw new ResourceNotFoundException(id,
                ZonedDateTime.now(),
                MessageConstants.RESOURCE_NOT_FOUND);
    };

    public static final Supplier<ResourceNotFoundException>
                      getResourceNotFoundException(Object id) {
        return () ->
                new ResourceNotFoundException(id,
                        ZonedDateTime.now(),
                        MessageConstants.RESOURCE_NOT_FOUND);
    }
    
    private ExceptionUtil(){}
}