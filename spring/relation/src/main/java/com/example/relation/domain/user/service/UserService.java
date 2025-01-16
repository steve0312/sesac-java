package com.example.relation.domain.user.service;

import com.example.relation.domain.post.dto.Post2ListPageResponseDto;
import com.example.relation.domain.post.repository.Post2Repository;
import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.response.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Post2Repository post2Repository;

    // 로그인한 유저 정보 확인하기
    public UserResponseDto getMyProfile(User user) {
        // userRepository 생략 가능
        // JWT 파싱할 때 UserDetails를 통해 데이터를 가져오기 때문에 (JwtAuthenticationFilter에서 4번에 해당)

        return UserResponseDto.from(user);
    }


    // 내가 작성한 Post 보기
    public Post2ListPageResponseDto getMyPosts(User user, Pageable pageable) {
        return Post2ListPageResponseDto.from(post2Repository.findAllByAuthorId(user.getId(), pageable));
    }
}
