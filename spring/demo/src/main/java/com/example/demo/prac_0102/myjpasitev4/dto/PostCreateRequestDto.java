package com.example.demo.prac_0102.myjpasitev4.dto;

import com.example.demo.prac_0102.myjpasitev4.PostV4;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

// title, content, author 를 받아다가 Post로 만드는 역할을 함
@Getter
@NoArgsConstructor
public class PostCreateRequestDto {
    // id는 DB가 자동으로 생성하는 값이라 필드를 만들지 않음
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Length(max = 20, message = "제목은 20자 이하여야 합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력 값입니다.")
    @Length(min = 5, message = "내용은 최소 5자 이상이어야 합니다.")
    private String content;

    @Length(min = 2, max = 10, message = "작성자 이름은 2자 이상 10자 이하여야 합니다.")
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
