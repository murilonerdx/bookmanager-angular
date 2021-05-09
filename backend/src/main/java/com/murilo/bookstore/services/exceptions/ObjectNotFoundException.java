package com.murilo.bookstore.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
