package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto;
import com.example.relation.domain.post.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    // JOIN을 통해 post id에 해당하는 Post 조회 (Post와 Comment 접근 가능)
    @Query("SELECT p FROM Post p LEFT JOIN p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithComment(@Param("id") Long id);

    // fetch join
    @Query("SELECT p FROM Post p LEFT JOIN FETCH  p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithCommentFetch(@Param("id") Long id);

    // fetch join을 통한 N+1 문제 해결
    @Query("SELECT p FROM Post p LEFT JOIN FETCH  p.comments")
    List<Post> findAllWithCommentFetch();

    // @EntityGraph 사용
    @EntityGraph(attributePaths = {"comments"})
    @Query("SELECT p FROM Post p")
    List<Post> findAllWithCommentEntityGraph();


    // reacord
    @Query("SELECT p, COUNT(c) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    // 지금 게시글과 댓글 갯수 반환하게 되므로 Object[] 사용
    List<Object[]> findAllWithCommentCount();

    // DTO 활용
    @Query("SELECT new com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto(p.id, p.title, p.createdAt, COUNT(c)) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    List<PostListWithCommentCountResponseDto> findAllWithCommentCountDTO();
}
