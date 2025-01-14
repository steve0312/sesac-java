package com.example.relation.domain.post.dto;

import com.example.relation.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostListWithPageResponseDto {
    // 기존에 출력하던 게시글들의 목록
    private final List<PostListResponseDto> posts;

    private final long totalPages;
    private final boolean hasNext;
    private final boolean hasPrevious;

    // hasNext, totalPages 등을 필드로 사용하기 위해 Page 사용하고 getContent 등의 메서드 사용
    public static PostListWithPageResponseDto from(Page<Post> posts) {
        return PostListWithPageResponseDto.builder()
                .posts(
                        posts.getContent().stream()
                                .map(PostListResponseDto::from)
                                .toList()
                )
                .totalPages(posts.getTotalPages())
                .hasNext(posts.hasNext())
                .hasPrevious(posts.hasPrevious())
                .build();
    }

    // PostListResponseDto를 이렇게 이너 클래스로도 활용할 수 있음
//    @Getter
//    @Builder
//    static class PostListResponseDto {
//        private Long id;
//        private String title;
//        private LocalDateTime createdAt;
//        private LocalDateTime updatedAt;
//
//        public static PostListResponseDto from(Post entity){
//            return PostListResponseDto.builder()
//                    .id(entity.getId())
//                    .title(entity.getTitle())
//                    .createdAt(entity.getCreatedAt())
//                    .updatedAt(entity.getUpdatedAt())
//                    .build();
//        }
//    }
}
