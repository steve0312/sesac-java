package com.example.relation.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // 1. application.properties 에 있는 변수 가져오기
    @Value("${jwt.secret}")
    private String secretKey;

    // 2. 만료 기간 설정 (application.properties 에서 설정해도 됨)
    // 1000L * 60 * 60 => 1시간
    private final long tokenValidityInMilliseconds = 1000L * 60 * 60 * 24; // 24시간

    @PostConstruct
    protected void init() {
        // 단순한 String 형태의 secretKey를 한 번 더 인코딩함
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(Authentication authentication) {
        // 1. payload에 담을 username 가져오기
        // 유저를 식별하기 위해 username을 가져옴
        String username = authentication.getName();
        // 2. claims에 username 넣어주기
        // Claims는 JWT에 값을 넣어주기 위한 장치 (payload에 값을 넣어줌)
        // {claims : payload에 들어갈 정보} 형태로 값이 전달됨
        Claims claims = Jwts.claims().setSubject(username);

        // 지금의 시간이랑 아까 설정한 만료 기간을 JWT에 넣어줌
        Date now = new Date();
        Date validity = new Date(now.getTime() + tokenValidityInMilliseconds);

        return Jwts.builder()
                // payload 채우기
                .setClaims(claims)
                // 만든 시간 넣기
                .setIssuedAt(now)
                // 만료 시간 넣기
                .setExpiration(validity)
                // 서명 넣기
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
