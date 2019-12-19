package com.poc.framework;

@FunctionalInterface
public interface ValidateRequestFormData<F> {
    void validate(F f);
}