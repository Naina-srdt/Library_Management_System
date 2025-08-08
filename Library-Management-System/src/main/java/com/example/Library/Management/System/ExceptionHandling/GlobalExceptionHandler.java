package com.example.Library.Management.System.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException exception){
        Map<String, Object> error = new HashMap<>();
        error.put("TimeStamp", LocalDateTime.now());
        error.put("error", exception.getMessage());
        error.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherException(Exception ex){
        Map<String, Object> error = new HashMap<>();
        error.put("TimeStamp", LocalDateTime.now());
        error.put("error", "Internal Server Error");
        error.put("details", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
