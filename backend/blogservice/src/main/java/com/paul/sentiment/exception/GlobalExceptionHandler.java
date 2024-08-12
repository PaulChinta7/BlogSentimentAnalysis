package com.paul.sentiment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BlogNotFoundException.class)    
    public ResponseEntity<ErrorResponse> handleBlogNotFoundException(String msg){
        return new ResponseEntity<>(ErrorResponse.builder().msg(msg).status(404).build(), HttpStatus.NOT_FOUND);
    }
}
