package com.example.jpamini.springdatajpa.global.errors;

// Service 계층 검증으로 이메일 중복 체크를 위해 만든 커스텀 예외
public class DuplicationEmailException extends RuntimeException {
    public DuplicationEmailException(String message) {
        super(message);
    }

    public DuplicationEmailException() {
        super("이미 사용 중인 이메일입니다.");
    }
}
