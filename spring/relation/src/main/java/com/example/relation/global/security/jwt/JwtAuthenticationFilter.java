package com.example.relation.global.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    // JWT를 가지고 인증시켜줌 (검사)
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 1. 요청으로부터 JWT 토큰 가져오기
        String token = getTokenFromRequest(request);

        // 2. 토큰에 값이 있는지 확인하고, 유효성 검사(Validation Check)
        if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
            // 3. 토큰의 payload에서 username 가져오기
            String username = jwtTokenProvider.getUsername(token);

            // 4. userRepository에서 username을 통해 데이터 가져오기
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 5. user data를 바탕으로 "authentication", 즉 인증 객체 만들기
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            // 6. SecurityContext에 인증 객체 넣기
            //    => SecurityContext : 사용자의 인증 정보를 저장, 관리하는 객체
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        // 1. 요청의 header로부터 "Authorization" 라는 key값을 가지는 value를 가지고 싶다.
        String bearerToken = request.getHeader("Authorization");
        // 2. 그 value가 비어있지 않고, Bearer로 시작하면 뒤에 있는 token을 반환함
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
