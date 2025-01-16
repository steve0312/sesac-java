package com.example.relation.domain.user.service;

import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.response.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto getMyProfile(User user) {
        // userRepository 생략 가능
        // JWT 파싱할 때 UserDetails를 통해 데이터를 가져오기 때문에 (JwtAuthenticationFilter에서 4번에 해당)

        return UserResponseDto.from(user);
    }
}
