package com.murilo.bookstore.resources.exceptions;

public class FieldMessage {
    private String name;
    private String message;

    public FieldMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public FieldMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
