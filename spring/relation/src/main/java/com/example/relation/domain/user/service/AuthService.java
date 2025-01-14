package com.example.relation.domain.user.service;

import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.SignupResponseDto;
import com.example.relation.domain.user.dto.request.SignupRequestDto;
import com.example.relation.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // @RequiredArgsConstructor 를 대체
    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public SignupResponseDto signup(SignupRequestDto requestDto) {
        // Service 계층에서의 Validation Check
        if(userRepository.existsByUsername(requestDto.getUsername())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        if(userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        // requestDto에서 username, password, email을 설정하기 때문에 암호화된 비밀번호를 사용하도록 넘겨줌
        User user = requestDto.toEntity(encodedPassword);

        return SignupResponseDto.from(userRepository.save(user));
    }
}
