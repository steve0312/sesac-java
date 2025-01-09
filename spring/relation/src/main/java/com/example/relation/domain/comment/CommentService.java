package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.comment.dto.CommentResponseDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.PostRepository;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // Create
    @Transactional
    public CommentResponseDto createComment(Long postId, CommentRequestDto requestDto) {
        // 게시글 찾음
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 찾은 게시글에 새로운 댓글 생성
        // Comment <- Post 이므로 연관관계 편의 메서드를 설정하게 됨
        Comment comment = requestDto.toEntity(post);

        return CommentResponseDto.from(commentRepository.save(comment));
    }


    // Update
    @Transactional
    public CommentResponseDto updateComment(Long postId, Long commentId, CommentRequestDto requestDto) {
        // 영속 상태가 됨
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException());

        // Dirty Checking에 의해서 save 메서드를 사용하지 않아도 알아서 변경사항이 DB에 반영됨
        comment.update(requestDto);

        return CommentResponseDto.from(comment);
    }
}
