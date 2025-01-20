package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.PostCreateRequestDto;
import com.example.relation.domain.post.dto.PostResponseDto;
import com.example.relation.domain.post.dto.PostWithCommentResponseDto;
import com.example.relation.domain.post.dto.PostWithCommentResponseDtoV2;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.global.exception.ResourceNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private PostService postService;

    @Test
    void createPost_성공() {
        // given
        PostCreateRequestDto requestDto = new PostCreateRequestDto(
                "테스트 제목",
                "테스트 내용",
                "테스트 작성자"
        );

        Post post = requestDto.toEntity();

        given(postRepository.save(any(Post.class)))
                .willReturn(post);

        // when
        PostResponseDto result = postService.createPost(requestDto);

        // then
        // result가 title로 "테스트 제목" 을 가지는지 검증
        assertThat(result.getTitle()).isEqualTo("테스트 제목");

        // result가 content로 "테스트 내용" 을 가지는지 검증
        assertThat(result.getContent()).isEqualTo("테스트 내용");

        // postRepository의 save 메서드를 호출한 게 맞는지 검증
        verify(postRepository).save(any(Post.class));
    }

    @Test
    void readPostByIdV2_성공() {
        // given
        Long postId = 1L;

        Post post = Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("테스트 작성자")
                .build();

        Comment comment = Comment.builder()
                .content("댓글 내용")
                .post(post)
                .build();

        // postRepository에 있는 findByIdWithComment를 호출했을 때, post가 comment랑 같이 왔으면 좋겠다.
        given(postRepository.findByIdWithComment(postId))
                .willReturn(Optional.of(post));

        // when
        PostWithCommentResponseDtoV2 result = postService.readPostByIdV2(postId);

        // then
        // result에 결과가 잘 들어갔는지 검증
        assertThat(result).isNotNull();

        // result가 title을 잘 가지고 있는지 검증
        assertThat(result.getTitle()).isEqualTo("테스트 제목");

        // result가 content 잘 가지고 있는지 검증
        assertThat(result.getTitle()).isEqualTo("테스트 내용");

        // result가 comments 잘 가지고 있는지 검증
        assertThat(result.getComments()).hasSize(1);

        // result의 comments 중 첫 번째 댓글의 내용이 "댓글 내용" 인지 검증
        assertThat(result.getComments().getFirst().getContent()).isEqualTo("댓글 내용");

        // postRepository의 findByIdWithComment 메서드를 호출한 게 맞는지 검증
        verify(postRepository).findByIdWithComment(postId);
    }

    @Test
    void readPostById_실패_게시글이_없는_경우() {
        // given
        Long postId = 999L;

        // 없는 id의 게시글을 조회했을 때 없다(비어있다)는 것을 테스트 하기 위함
        given(postRepository.findById(postId))
                .willReturn(Optional.empty());

        // when
        // postService.readPostById(postId) 를 실행했을 때 ResourceNotFoundException 이 발생한다는 것을 테스트
        assertThatThrownBy(() -> postService.readPostById(postId))
                .isInstanceOf(ResourceNotFoundException.class);

        // then
        // postRepository의 findById 메서드를 호출한 게 맞는지 검증
        verify(postRepository).findById(postId);
        // 절대 실행이 안 됬을 거라고 판단하고 검증
        verify(commentRepository, never()).findByPostId(postId);
    }
}