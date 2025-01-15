package com.example.relation.domain.user.controller;

import com.example.relation.domain.user.dto.request.LoginRequestDto;
import com.example.relation.domain.user.dto.response.SignupResponseDto;
import com.example.relation.domain.user.dto.request.SignupRequestDto;
import com.example.relation.domain.user.dto.response.TokenResponseDto;
import com.example.relation.domain.user.service.AuthService;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponseDto>> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                "유저가 정상적으로 생성되었습니다.",
                                "CREATED",
                                authService.signup(requestDto)
                        )
                );
    }

    // 로그인
    // ID, PW를 받아다가 만들거라서 RequestDTO가 필요함. RequestDTO는 @PostMapping을 사용함
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        authService.login(requestDto)
                )
        );
    }
}
