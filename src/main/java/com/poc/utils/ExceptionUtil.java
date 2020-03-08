package com.poc.utils;

import com.poc.constants.MessageConstants;
import com.poc.framework.exceptions.ResourceNotFoundException;

import java.time.ZonedDateTime;
import java.util.function.IntConsumer;

public class ExceptionUtil {

    public static final IntConsumer throwResourceNotFoundException = id -> {
        throw new ResourceNotFoundException(id,
                ZonedDateTime.now(),
                MessageConstants.RESOURCE_NOT_FOUND);
    };

    private ExceptionUtil(){}
}
