package com.paul.sentiment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BlogNotFoundException.class)  
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleBlogNotFoundException(BlogNotFoundException ex){
        return new ResponseEntity<>(ErrorResponse.builder().msg(ex.getMessage()).status(404).build(), HttpStatus.NOT_FOUND);
    }
}
