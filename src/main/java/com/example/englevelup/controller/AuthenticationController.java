package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.authentication.UserLoginRequestDto;
import com.example.englevelup.dto.internal.authentication.UserLoginResponseDto;
import com.example.englevelup.dto.internal.user.UserRequestDto;
import com.example.englevelup.dto.internal.user.UserResponseDto;
import com.example.englevelup.security.AuthenticationService;
import com.example.englevelup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        return userService.register(userRequestDto);
    }

    @PostMapping("/login")
    UserLoginResponseDto authenticate(@RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
