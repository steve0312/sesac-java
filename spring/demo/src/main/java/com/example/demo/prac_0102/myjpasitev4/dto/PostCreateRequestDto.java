package com.example.demo.prac_0102.myjpasitev4.dto;

import com.example.demo.prac_0102.myjpasitev4.PostV4;
import lombok.Getter;
import lombok.NoArgsConstructor;

// title, content, author 를 받아다가 Post로 만드는 역할을 함
@Getter
@NoArgsConstructor
public class PostCreateRequestDto {
    // id는 DB가 자동으로 생성하는 값이라 필드를 만들지 않음
    private String title;
    private String content;
    private String author;

    public PostV4 toEntity() {
        return PostV4.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
        // return new PostV4(title, content, author); 와 위의 코드는 동일
    }
}
