package com.example.demo.prac_0102.myjpasitev4.dto;

import com.example.demo.prac_0102.myjpasitev4.PostV4;
import lombok.Getter;
import lombok.NoArgsConstructor;

// title, content, author 를 받아다가 Post로 만드는 역할을 함
@Getter
// 생성자가 하나도 없으면 컴파일러가 자동으로 만들어줘서 생략 가능하긴 한데 기본적으로 붙여주는게 좋음
@NoArgsConstructor
public class PostUpdateRequestDto {
    // id는 DB가 자동으로 생성하는 값이라 필드를 만들지 않음
    private String title;
    private String content;

    // toEntity 메서드는 생성해주는 내용이므로 수정에는 맞지 않아서 지움
//    public PostV4 toEntity() {
//        return PostV4.builder()
//                .title(this.title)
//                .content(this.content)
//                .build();
//        // return new PostV4(title, content); 와 위의 코드는 동일
//    }
}
