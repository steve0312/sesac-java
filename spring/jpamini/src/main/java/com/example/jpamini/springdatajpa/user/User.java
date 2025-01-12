package com.example.jpamini.springdatajpa.user;

import com.example.jpamini.springdatajpa.team.Team;
import com.example.jpamini.springdatajpa.user.dto.UserUpdateRequestDto;
import com.example.jpamini.springdatajpa.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String nickName;
    private Integer age;
    @Column(nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public User(String userName, String email, String nickName, Integer age, Boolean isActive, Team team) {
        this.userName = userName;
        this.email = email;
        this.nickName = nickName;
        this.age = age;
        this.isActive = true;
        setTeam(team);
    }

    // 연관관계 편의 메서드 설정
    public void setTeam(Team team) {
        this.team = team;
        team.getUsers().add(this);
    }

    // 유저에 대한 필드를 수정할 때 사용하는 메서드
    public User update(UserUpdateRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.nickName = requestDto.getNickName();
        this.age = requestDto.getAge();
        this.isActive = requestDto.getIsActive();

        return this;
    }
}
