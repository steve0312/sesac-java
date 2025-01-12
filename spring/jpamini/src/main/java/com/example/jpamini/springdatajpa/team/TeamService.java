package com.example.jpamini.springdatajpa.team;

import com.example.jpamini.springdatajpa.global.errors.ResourceNotFoundException;
import com.example.jpamini.springdatajpa.team.dto.TeamRequestDto;
import com.example.jpamini.springdatajpa.team.dto.TeamResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;


    // Create
    @Transactional
    public TeamResponseDto createTeam(TeamRequestDto requestDto) {
        Team team = teamRepository.save(requestDto.toEntity());

        return TeamResponseDto.from(team);
    }


    // Read- 전체
    public List<TeamResponseDto> readTeams() {
        return teamRepository.findAll().stream()
                .map(TeamResponseDto::from)
                .toList();
    }

    // Read- 단일
    public TeamResponseDto readTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        return TeamResponseDto.from(team);
    }


    // Update
    @Transactional
    public TeamResponseDto updateTeam(Long id, TeamRequestDto requestDto) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        team.update(requestDto);

        return TeamResponseDto.from(team);
    }


    // Delete
    @Transactional
    public void deleteTeam(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        teamRepository.delete(team);
    }
}
