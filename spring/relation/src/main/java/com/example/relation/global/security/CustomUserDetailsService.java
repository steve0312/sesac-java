package com.example.relation.global.security;

import com.example.relation.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// 역할을 분리하기 위해서 커스텀 서비스를 만듦
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    // User를 반환해도 되는데 다형성을 활용해서 UserDetails 반환
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
