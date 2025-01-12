package com.example.jpamini.springdatajpa.team;

import com.example.jpamini.springdatajpa.team.dto.TeamRequestDto;
import com.example.jpamini.springdatajpa.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String teamName;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "team")
    private List<User> user;

    @Builder
    public Team(String teamName, LocalDateTime createdAt) {
        this.teamName = teamName;
        this.createdAt = createdAt;
    }

    public Team update(TeamRequestDto requestDto) {
        this.teamName = requestDto.getTeamName();

        return this;
    }
}
