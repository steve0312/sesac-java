package com.example.relation.domain.post.dto;

import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.Post2;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
public class Post2ListPageResponseDto {
    // 기존에 출력하던 게시글들의 목록
    private final List<Post2ResponseDto> posts;

    private final long totalPages;
    private final boolean hasNext;
    private final boolean hasPrevious;

    // hasNext, totalPages 등을 필드로 사용하기 위해 Page 사용하고 getContent 등의 메서드 사용
    public static Post2ListPageResponseDto from(Page<Post2> posts) {
        return Post2ListPageResponseDto.builder()
                .posts(
                        posts.getContent().stream()
                                .map(Post2ResponseDto::from)
                                .toList()
                )
                .totalPages(posts.getTotalPages())
                .hasNext(posts.hasNext())
                .hasPrevious(posts.hasPrevious())
                .build();
    }
}
