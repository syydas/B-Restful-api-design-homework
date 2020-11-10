package com.thoughtworks.capability.gtb.restfulapidesign.expection;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }
}
