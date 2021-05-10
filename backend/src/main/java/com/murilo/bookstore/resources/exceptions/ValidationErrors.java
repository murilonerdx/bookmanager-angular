package com.murilo.bookstore.resources.exceptions;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors extends StandardError{
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationErrors(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fildName, String message) {
        this.errors.add(new FieldMessage(fildName, message));
    }
}
