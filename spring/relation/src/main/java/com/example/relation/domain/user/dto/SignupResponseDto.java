package com.example.relation.domain.user.dto;

import com.example.relation.domain.user.entity.Role;
import com.example.relation.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponseDto {
    private String username;
    // 비밀번호는 응답할 필요 없으므로 제외했음
    private String email;
    private Role role;

    public static SignupResponseDto from(User entity){
        return SignupResponseDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }
}

