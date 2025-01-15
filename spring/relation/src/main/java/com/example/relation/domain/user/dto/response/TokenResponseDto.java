package com.example.relation.domain.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenResponseDto {
    // Refresh Token을 만들 수 있어서 필요
    private final String token;
}
