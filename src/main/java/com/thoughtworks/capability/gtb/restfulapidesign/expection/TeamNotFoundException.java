package com.thoughtworks.capability.gtb.restfulapidesign.expection;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException(String message) {
        super(message);
    }
}
