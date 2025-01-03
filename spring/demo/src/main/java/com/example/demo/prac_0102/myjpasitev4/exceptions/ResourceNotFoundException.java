package com.example.demo.prac_0102.myjpasitev4.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException() {
        super("리소스를 찾을 수 없습니다.");
    }
}
