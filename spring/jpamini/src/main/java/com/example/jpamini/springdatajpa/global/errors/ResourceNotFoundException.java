package com.example.jpamini.springdatajpa.global.errors;

// 특정 유저 조회에 실패했을 때 발생시키기 위해 만든 커스텀 예외
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("리소스를 찾을 수 없습니다.");
    }
}
