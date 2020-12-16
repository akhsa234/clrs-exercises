package com.bahar.blog.service;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ResourceNotFoundException(Long id) {
        super("Could not find Tag " + id);
    }


}
