package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.comment.dto.CommentResponseDto;
import com.example.relation.domain.post.Post;
import com.example.relation.domain.post.PostRepository;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Comment comment = requestDto.toEntity(post);

        return CommentResponseDto.from(commentRepository.save(comment));
    }

}
