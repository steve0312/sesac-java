package com.example.jpamini.springdatajpa.dto;

import com.example.jpamini.springdatajpa.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserListResponseDto {
    private final Long id;
    private final String userName;

    // 유저에 대한 전체 조회를 진행할 때 엔티티가 아닌 ResponseDTO를 반환해야 하므로 변환하기 위한 메서드
    // User 엔티티 -> UserListResponseDto
    public static UserListResponseDto from(User entity) {
        return UserListResponseDto.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .build();
    }
}
