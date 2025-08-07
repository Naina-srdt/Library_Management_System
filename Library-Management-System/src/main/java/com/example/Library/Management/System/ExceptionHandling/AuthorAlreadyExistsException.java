package com.example.Library.Management.System.ExceptionHandling;

public class AuthorAlreadyExistsException extends RuntimeException{
    private String message;

    public AuthorAlreadyExistsException() {}

    public AuthorAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
