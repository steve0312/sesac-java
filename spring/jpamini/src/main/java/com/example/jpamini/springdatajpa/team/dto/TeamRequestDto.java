package com.example.jpamini.springdatajpa.team.dto;

import com.example.jpamini.springdatajpa.team.Team;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestDto {
    @NotBlank
    private String teamName;

    public Team toEntity() {
        return Team.builder()
                .teamName(this.teamName)
                .build();
    }
}
