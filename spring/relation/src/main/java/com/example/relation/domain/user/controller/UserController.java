package com.example.relation.domain.user.controller;

import com.example.relation.domain.user.dto.response.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.domain.user.service.UserService;
import com.example.relation.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/my/profile")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile() {
        // SecurityContext에서 인증된 객체 꺼내오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // authentication.getPrincipal() 은 Object 를 반환하는데 형변환을 통해 User로 변환
        // 요청해서 가져온 데이터에 대한 처리 (Service에서 해도 되는데 수업에서는 비즈니스 로직에 좀 더 집중하기 위해 여기서 처리)
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.getMyProfile(user)
                )
        );
    }
}
