package com.thoughtworks.capability.gtb.restfulapidesign.expection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
        String message = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(StudentExistsException.class)
    public ResponseEntity<ErrorResult> handle(StudentExistsException e) {
        ErrorResult errorResult = new ErrorResult(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResult> handle(StudentNotFoundException e) {
        ErrorResult errorResult = new ErrorResult(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<ErrorResult> handle(TeamNotFoundException e) {
        ErrorResult errorResult = new ErrorResult(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
