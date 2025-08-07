package com.example.Library.Management.System.ExceptionHandling;

public class NoSuchAuthorExistsException {
    private String message;

    public NoSuchAuthorExistsException() {}

    public NoSuchAuthorExistsException(String msg) {
        super();
        this.message = msg;
    }
}
