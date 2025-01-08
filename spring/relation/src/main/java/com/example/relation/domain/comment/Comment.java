package com.example.relation.domain.comment;

import com.example.relation.domain.post.Post;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    // Post와의 연관 관계
    // table에서는 post_id, 엔티티에서는 Post 자체를 가져옴
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }
}
