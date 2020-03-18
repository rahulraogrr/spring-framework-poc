package com.poc.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.function.BiFunction;

import static com.poc.utils.ExceptionUtil.getResourceNotFoundException;

public class ValidationUtil {

    /*public static final BiFunction<Object, JpaRepository, Optional<?>>
            validateAndGetRecord = (id, repository) ->
                        Optional.ofNullable(repository
                                .findById(id)
            );*/
}