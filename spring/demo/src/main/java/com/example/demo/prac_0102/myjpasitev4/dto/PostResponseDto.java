package com.example.demo.prac_0102.myjpasitev4.dto;

import com.example.demo.prac_0102.myjpasitev4.PostV4;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
// @Builder를 쓰면 @AllArgsConstructor 가 자동으로 생성됨
@Builder
public class PostResponseDto {
    private final Long id;

    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createAt;
    private final LocalDateTime updatedAt;

    // 인스턴스가 존재하지 않는 상황이라서 static 메서드 사용
    public static PostResponseDto from(PostV4 entity) {
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .createAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
        // return new PostResponseDto(entity.getId(), entity.getTitle(), entity.getContent(), entity.getAuthor); 와 위의 코드는 동일
    }
}
