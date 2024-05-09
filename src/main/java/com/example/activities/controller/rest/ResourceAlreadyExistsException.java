package com.example.activities.controller.rest;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String msg) {
        super (msg);
    }
}
