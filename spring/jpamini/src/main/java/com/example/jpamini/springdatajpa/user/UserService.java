package com.example.jpamini.springdatajpa.user;

import com.example.jpamini.springdatajpa.team.Team;
import com.example.jpamini.springdatajpa.team.TeamRepository;
import com.example.jpamini.springdatajpa.user.dto.UserCreateRequestDto;
import com.example.jpamini.springdatajpa.user.dto.UserListResponseDto;
import com.example.jpamini.springdatajpa.user.dto.UserResponseDto;
import com.example.jpamini.springdatajpa.user.dto.UserUpdateRequestDto;
import com.example.jpamini.springdatajpa.global.errors.DuplicationEmailException;
import com.example.jpamini.springdatajpa.global.errors.DuplicationUserNameException;
import com.example.jpamini.springdatajpa.global.errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    // Create
    @Transactional
    public UserResponseDto createUser(Long teamId, UserCreateRequestDto requestDto) {
        // 유저 이름은 중복 불가하므로 체크
        if(userRepository.existsByUserName(requestDto.getUserName())) {
            throw new DuplicationUserNameException();
        }

        // 이메일은 중복 불가하므로 체크
        if(userRepository.existsByEmail(requestDto.getEmail())) {
            throw new DuplicationEmailException();
        }

        // 팀 찾음
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 찾은 팀에 새로운 유저 생성
        // User <- Team
        User user = userRepository.save(requestDto.toEntity(team));

        return UserResponseDto.from(user);
    }


    // Read- 전체
    public List<UserListResponseDto> readUsers() {
        return userRepository.findAll().stream()
                .map(UserListResponseDto::from)
                .toList();
    }

    // Read- 단일
    public UserResponseDto readUserById(Long id) {
        // 유저를 조회해서 있으면 반환하고 없으면 ResourceNotFoundException 예외 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        return UserResponseDto.from(user);
    }

    // 특정 닉네임을 가진 사용자 조회
    public List<UserResponseDto> readUserByNickName(String nickName) {
        return userRepository.findByNickName(nickName).stream()
                .map(UserResponseDto::from)
                .toList();
    }

    // 특정 나이의 사용자 조회
    public List<UserResponseDto> readUserByAge(Integer age) {
        return userRepository.findByAge(age).stream()
                .map(UserResponseDto::from)
                .toList();
    }

    // 활성화된 사용자 조회
    public List<UserResponseDto> readUserByActive() {
        return userRepository.findByActive().stream()
                .map(UserResponseDto::from)
                .toList();
    }

    // 이메일이 특정 도메인으로 끝나는 사용자 조회
    public List<UserResponseDto> readUserByEmailDomain(String domain) {
        return userRepository.findByEmailDomain(domain).stream()
                .map(UserResponseDto::from)
                .toList();
    }

    // 특정 나이 이후의 비활성 사용자 조회
    public List<UserResponseDto> readUserByAfterAgeInActive(Integer age) {
        return userRepository.findByAfterAgeInActive(age).stream()
                .map(UserResponseDto::from)
                .toList();
    }


    // Update
    @Transactional
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto requestDto) {
        // 유저를 조회해서 있으면 반환하고 없으면 ResourceNotFoundException 예외 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 이메일은 중복 불가하므로 체크
        if(userRepository.existsByEmail(requestDto.getEmail())) {
            throw new DuplicationEmailException();
        }

        // 유저에 대한 수정 진행
        user.update(requestDto);

        return UserResponseDto.from(user);
    }


    // Delete
    @Transactional
    public void deleteUser(Long id) {
        // 유저를 조회해서 있으면 반환하고 없으면 ResourceNotFoundException 예외 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 유저 삭제
        userRepository.delete(user);
    }
}
