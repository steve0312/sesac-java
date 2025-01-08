package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
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
//        this.post = post;
        setPost(post);
    }

    // 연관관계 편의 메서드 설정
    public void setPost(Post post) {
        this.post = post;
//        comment.post = post
        // Post는 mappedBy에 의해 읽기 전용이므로 DB에는 반영이 안 됨
        // 프로그램 상에서 양쪽 모두에 연관관계를 설정하는 개념
        post.getComments().add(this);
        // post.getComments().add(comment); 와 위는 동일 개념
    }

    // setter라고 네이밍해도 되는데 RequestDTO로부터 업데이트 했다는 의미를 주기 위해 update 라고 네이밍
    public Comment update(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();

        return this;
    }
}
