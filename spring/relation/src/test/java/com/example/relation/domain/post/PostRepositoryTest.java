package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private Post post;
    private Comment comment1;
    private Comment comment2;

    // 테스트를 위한 기본적인 데이터를 만들어놨다
    @BeforeEach
    void setUp() {
        post = new Post("테스트 제목", "테스트 내용", "테스트 작성자");
        post = postRepository.save(post);

        comment1 = new Comment("댓글1", post);
        comment2 = new Comment("댓글2", post);
        commentRepository.save(comment1);
        commentRepository.save(comment2);
    }

    @Test
    void findByIdWithComment_성공() {
        // given
        // post, comment 가 DB에 존재하는 상황
        // @BeforeEach 에서 이미 처리했음

        // when
        // 내가 post를 findById~~ 했을 때, 그 결과가
        Optional<Post> foundPost = postRepository.findByIdWithComment(post.getId());

        // then
        // 여기서 검증되었으면 좋겠다.
        // - 테스트 해볼 것
        // 1. post가 존재한다.
        Assertions.assertThat(foundPost).isPresent();

        // 2. post에 대한 comment가 2개 존재한다.
        Assertions.assertThat(foundPost.get().getComments()).hasSize(2);

        // 3. post에 대한 comment 중 첫 번째의 content가 "댓글1"이다.
        Assertions.assertThat(foundPost.get().getComments().getFirst().getContent()).isEqualTo("댓글1");
    }
}