package com.example.relation.domain.post.dto;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.dto.CommentResponseDto;
import com.example.relation.domain.post.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
// JOIN 방식의 Read에 활용
public class PostWithCommentResponseDtoV2 {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<CommentResponseDto> comments;

    // JOIN 방식을 사용했으므로 PostWithCommentResponseDto 와 다르게 매개변수로 List<Comment>를 받지 않고 사용
    public static PostWithCommentResponseDtoV2 from(Post entity) {
        return PostWithCommentResponseDtoV2.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .comments(
                        entity.getComments().stream()
                                .map(CommentResponseDto::from)
                                .toList()
                )
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
