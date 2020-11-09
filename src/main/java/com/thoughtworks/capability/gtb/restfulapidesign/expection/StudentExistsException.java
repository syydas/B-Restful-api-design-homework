package com.thoughtworks.capability.gtb.restfulapidesign.expection;

public class StudentExistsException extends RuntimeException{

    public StudentExistsException(String message) {
        super(message);
    }
}
