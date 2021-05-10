package com.murilo.bookstore.resources.exceptions;

import com.murilo.bookstore.services.exceptions.DataIntegrityException;
import com.murilo.bookstore.services.exceptions.EmptyResultDataException;
import com.murilo.bookstore.services.exceptions.HttpRequestMethodSupportedException;
import com.murilo.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityException e, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmptyResultDataException.class)
    public ResponseEntity<StandardError> emptyResultDataException(EmptyResultDataException e, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(HttpRequestMethodSupportedException.class)
    public ResponseEntity<StandardError> emptyResultDataException(HttpRequestMethodSupportedException e, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationErrors error = new ValidationErrors(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro validação dos campos");
        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addErrors(x.getField(),x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> emptyResultDataException(HttpRequestMethodNotSupportedException e, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Metodo não suportado - HttpRequestMethodNotSupportedException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }



}