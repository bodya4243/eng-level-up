package com.example.englevelup.service;

import com.example.englevelup.dto.internal.level.LevelResponseDto;
import com.example.englevelup.dto.internal.user.UserRequestDto;
import com.example.englevelup.dto.internal.user.UserResponseDto;
import com.example.englevelup.mapper.LevelMapper;
import com.example.englevelup.mapper.UserMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.Role;
import com.example.englevelup.model.User;
import com.example.englevelup.repository.RoleRepository;
import com.example.englevelup.repository.UserRepository;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final LevelMapper levelMapper;

    @Override
    public UserResponseDto register(UserRequestDto userRequestDto) {
        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new RuntimeException("user with email: "
                    + userRequestDto.getEmail()
                    + " already exists");
        }

        User user = userMapper.toModel(userRequestDto);
        Role defaultRole = (roleRepository.findByRole(Role.RoleName.USER));
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRoles(Collections.singleton(defaultRole));
        user.setLevel(EnglishLevel.A1);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public LevelResponseDto updateLevel(User user, EnglishLevel englishLevel) {
        Optional<User> userByEmail = userRepository.findByEmail(user.getEmail());

        if (userByEmail.isEmpty()) {
            throw new UsernameNotFoundException("User is not found by username: "
                    + user.getEmail());
        }
        User userToSave = userByEmail.get();
        userToSave.setLevel(englishLevel);

        userRepository.save(userToSave);

        return levelMapper.toDto(userToSave);
    }
}
