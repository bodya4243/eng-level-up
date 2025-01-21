package com.example.englevelup.security;

import com.example.englevelup.dto.internal.authentication.UserLoginRequestDto;
import com.example.englevelup.dto.internal.authentication.UserLoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password())
        );

        String token = jwtUtil.generateToken(authentication.getName(),
                authentication.getAuthorities());

        return new UserLoginResponseDto(token);
    }
}
