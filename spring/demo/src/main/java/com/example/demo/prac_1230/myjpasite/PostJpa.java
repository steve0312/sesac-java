package com.example.demo.prac_1230.myjpasite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpa {
    @Id
    // MySQL에서는 GenerationType.IDENTITY 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // title, content에 대한 setter 개념
    public PostJpa update(String title, String content) {
        this.title = title;
        this.content = content;

        // 메서드 반환 타입을 void로 바꾸면 생략 가능
        return this;
    }
}
