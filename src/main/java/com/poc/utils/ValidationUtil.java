package com.poc.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.function.BiFunction;

import static com.poc.utils.ExceptionUtil.getResourceNotFoundException;

public final class ValidationUtil {

    public static final BiFunction<? super Object ,
            JpaRepository<? super Object,? super Object>,
            Optional<? super Object>>
            validateAndGetRecord = (id,jpaRepository) ->
            Optional.ofNullable(
                    jpaRepository
                            .findById(id)
                            .orElseThrow(getResourceNotFoundException(id))
            );

    private ValidationUtil(){}
}