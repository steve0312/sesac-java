package com.example.jpamini.springdatajpa.team;

import com.example.jpamini.springdatajpa.global.response.ApiResponse;
import com.example.jpamini.springdatajpa.team.dto.TeamRequestDto;
import com.example.jpamini.springdatajpa.team.dto.TeamResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;


    // Create
    @PostMapping
    public ResponseEntity<ApiResponse<TeamResponseDto>> createTeam(@Valid @RequestBody TeamRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                "팀이 정상적으로 생성되었습니다.",
                                "CREATED",
                                teamService.createTeam(requestDto)
                        )
                );

    }


    // Read- 전체
    @GetMapping
    public ResponseEntity<ApiResponse<List<TeamResponseDto>>> readTeams() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        teamService.readTeams()
                )
        );
    }


    // Read- 단일
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeamResponseDto>> readTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        teamService.readTeamById(id)
                )
        );
    }


    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TeamResponseDto>> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        teamService.updateTeam(id, requestDto)
                )
        );
    }


    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTeam(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "팀이 정상적으로 삭제되었습니다.",
                        "DELETED",
                        null
                )
        );
    }
}
