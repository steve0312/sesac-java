package com.example.demo.prac_0102.myjpasitev4;

import com.example.demo.prac_0102.myjpasitev4.dto.PostUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostV4 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;
    private String content;
    private String author;

    @Builder
    // id를 제외한 빌더가 필요 => id를 제외한 생성자 필요
    // id는 데이터베이스에서 자동으로 생성 및 관리함
    public PostV4(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 수정에 대한 setter
    public PostV4 update(PostUpdateRequestDto postUpdateRequestDto) {
        this. title = postUpdateRequestDto.getTitle();
        this.content = postUpdateRequestDto.getContent();

        return this;
    }
}
