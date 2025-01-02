package com.example.demo.prac_0102.myjpasitev4.dto;

import com.example.demo.prac_0102.myjpasitev4.PostV4;
import lombok.Builder;
import lombok.Getter;

@Getter
// @Builder를 쓰면 @AllArgsConstructor 가 자동으로 생성됨
@Builder
// 보여줄 정보를 List로 제한
public class PostListResponseDto {
    private final Long id;

    private final String title;

    // 인스턴스가 존재하지 않는 상황이라서 static 메서드 사용
    public static PostListResponseDto from(PostV4 entity) {
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
        // return new PostResponseDto(entity.getId(), entity.getTitle()); 와 위의 코드는 동일
    }
}
