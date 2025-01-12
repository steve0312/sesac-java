package com.example.jpamini.springdatajpa.global.errors;

// Service 계층 검증으로 유저 이름 중복 체크를 위해 만든 커스텀 예외
public class DuplicationUserNameException extends RuntimeException {
    public DuplicationUserNameException(String message) {
        super(message);
    }

    public DuplicationUserNameException() {
        super("이미 사용 중인 이름입니다.");
    }
}
