package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostListResponseDto> readPosts(){
        return postRepository.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    // 방식 1
    // 게시글에 정보 따로, 해당 게시글에 대한 댓글 목록을 따로 만들어 Dto로 합쳐 전달
    public PostWithCommentResponseDto readPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        // 특정 post id를 가지고 있는 commets를 가져오고 싶다.
        List<Comment> comments = commentRepository.findByPostId(id);

        return PostWithCommentResponseDto.from(post, comments);
    }

    // 방식 2
    // JOIN을 통한 Read
    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id) {
        // post, comment를 한 번에 가져오고 싶다.
        Post post = postRepository.findByIdWithComment(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentResponseDtoV2.from(post);

        // dto로 변경해서 return한다.
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        post.update(requestDto);

        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        postRepository.delete(post);
    }
}
