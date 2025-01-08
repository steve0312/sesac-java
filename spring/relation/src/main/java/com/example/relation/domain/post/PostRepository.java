package com.example.relation.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    // JOIN을 통해 post id에 해당하는 Post 조회 (Post와 Comment 접근 가능)
    @Query("SELECT p FROM Post p LEFT JOIN p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithComment(@Param("id") Long id);
}
