package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.post.repository.PostTagRepository;
import com.example.relation.domain.tag.Tag;
import com.example.relation.domain.tag.TagRepository;
import com.example.relation.domain.tag.dto.TagRequestDto;
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
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;


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


    // record
    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCount() {
        List<Object[]> results = postRepository.findAllWithCommentCount();

        return results.stream()
                .map(
                        result -> {
                            Post post = (Post) result[0];
                            Long commentCount = (Long) result[1];

                            return new PostListWithCommentCountResponseDto(
                                    post.getId(),
                                    post.getTitle(),
                                    post.getCreatedAt(),
                                    commentCount
                            );
                        })
                .toList();
    }

    // DTO 활용
    public List<PostListWithCommentCountResponseDto> readPostWithCommentCountDto() {
        return postRepository.findAllWithCommentCountDTO();
    }


    // Create- PostTag
    // Post와 Tag를 가지고 연결시켜주기
    @Transactional
    public void addTagToPost(Long id, TagRequestDto requestDto) {
        // 게시글 찾음
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 태그를 찾음
        Tag tag = tagRepository.findByName(requestDto.getName())
                .orElseThrow(() -> new ResourceNotFoundException());

        PostTag postTag = new PostTag();

        // PostTag에 Post, Tag와의 연관관계 설정
        postTag.addTag(tag);
        postTag.addPost(post);

        // Post에 PostTag와의 연관관계 설정
        // addPost 메서드의 post.getPostTags().add(this); 내용과 동일한 효과
        post.getPostTags().add(postTag);

        postTagRepository.save(postTag);
    }


    // Read- 게시글을 댓글과 태그들과 함께 조회
    public PostWithCommentAndTagResponseDto readPostsByIdWithCommentAndTag(Long id) {
        // 댓글과 태그를 가진 게시글을 가져오자
//        Post post = postRepository.findByIdWithCommentAndTag(id)
//                .orElseThrow(() -> new ResourceNotFoundException());

        // 태그를 가진 게시글 가져옴
        Post postWithTag = postRepository.findByIdWithTag(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 게시글에 맞는 댓글 가져옴
        List<Comment> comments = commentRepository.findByPostId(id);

        // 하나의 ResponseDTO로 통합해서 반환
        return PostWithCommentAndTagResponseDto.from(postWithTag, comments);
    }


    // Read- Batch size 조절
    public PostWithCommentAndTagResponseDtoV2 readPostsByIdWithCommentAndTagV2(Long id) {
        // 댓글과 태그를 가진 게시글을 가져오자
        Post postWithTag = postRepository.findByIdWithCommentAndTag(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentAndTagResponseDtoV2.from(postWithTag);
    }


    // Tag별 게시글 가져오기
    public List<PostListResponseDto> readPostsByTag(String tag) {
        // 태그 이름에 맞는 게시글들을 가져옴
        return postRepository.findAllByTagName(tag).stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    // Tag별 게시글 가져오기- PostWithCommentAndTagResponseDtoV2 사용
//    public List<PostWithCommentAndTagResponseDtoV2> readPostsByTag(String tag) {
//        // 태그 이름에 맞는 게시글들을 가져옴
//        return postRepository.findAllByTagName(tag).stream()
//                .map(PostWithCommentAndTagResponseDtoV2::from)
//                .toList();
//    }
}
