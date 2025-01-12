package com.example.jpamini.springdatajpa.user.dto;

import com.example.jpamini.springdatajpa.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponseDto {
    private final Long id;
    private final String userName;
    private final String email;
    private final String nickName;
    private final Integer age;
    private final Boolean isActive;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    // 유저에 대한 생성, 단일 조회, 수정을 진행할 때 엔티티가 아닌 ResponseDTO를 반환해야 하므로 변환하기 위한 메서드
    // User 엔티티 -> UserResponseDto
    public static UserResponseDto from(User entity) {
        return UserResponseDto.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .nickName(entity.getNickName())
                .age(entity.getAge())
                .isActive(entity.getIsActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
