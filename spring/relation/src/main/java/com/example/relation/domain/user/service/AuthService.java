package com.example.relation.domain.user.service;

import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.request.LoginRequestDto;
import com.example.relation.domain.user.dto.response.SignupResponseDto;
import com.example.relation.domain.user.dto.request.SignupRequestDto;
import com.example.relation.domain.user.dto.response.TokenResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;


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


    // 로그인
    // 1. DTO 를 받는다.
    public TokenResponseDto login(LoginRequestDto requestDto){
        // 3. 객체로 만든 것을 manager에게 통과시켜 인증 정보가 들어있는 "authentication" 객체를 만든다.
        // 4. "authenticationManager" 를 활용하기 위해 DI를 해준다. => security config 로 이동

        // ID, PW를 전달해서 user table에 해당 유저가 존재하는지 확인
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        // 2. DTO로 부터 온 정보를 객체로 만든다.
                        requestDto.getUsername(),
                        requestDto.getPassword()
                )
        );
        // 5. 사용자에 대한 인증 정보가 들어있는 "authentication" 를 활용해서
        // SecurityContext라는 곳에 인증 정보를 저장한다. (인증이 됬는지 다른 애들은 모르기 때문에)
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 6. jwtTokenProvider를 DI해줘야 함 -> JwtTokenProvider를 만들어주자
        // 경로 : security/jwt/JwtTokenProvider
        String jwt = jwtTokenProvider.createToken(authentication);

        return new TokenResponseDto(jwt);
    }
}
