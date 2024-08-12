package com.paul.sentiment.exception;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String msg) {
        super(msg);
    }
}
