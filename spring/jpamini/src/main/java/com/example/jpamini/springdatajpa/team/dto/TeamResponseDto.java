package com.example.jpamini.springdatajpa.team.dto;


import com.example.jpamini.springdatajpa.team.Team;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TeamResponseDto {
    private final Long id;
    private final String teamName;
    private final LocalDateTime createdAt;

    public static TeamResponseDto from(Team entity) {
        return TeamResponseDto.builder()
                .id(entity.getId())
                .teamName(entity.getTeamName())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
