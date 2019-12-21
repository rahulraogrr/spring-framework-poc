package com.poc.framework;

@FunctionalInterface
public interface ValidateFormData<F,V,I> {
    void validate(F form,V verb,I id);
}