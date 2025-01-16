package com.example.relation.global.security;

public class SecurityPathConfig {
    // 아래의 url을 상수 모음처럼 사용하기  위해서 만듦
    public static final String[] PUBLIC_GET_URLS = {
            "/posts/**",
            "/tags/**"
    };
}
