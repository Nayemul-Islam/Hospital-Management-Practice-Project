package com.practice.HospitalMangement.service;

import com.practice.HospitalMangement.dto.UserRequestDto;
import com.practice.HospitalMangement.dto.UserResponseDto;
import com.practice.HospitalMangement.entity.User;
import com.practice.HospitalMangement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponseDto> getUser(String username, String email) {
        List<User> users;
        if (username == null && email == null) {
            users = userRepository.findAll();
        } else if (username != null) {
            users = userRepository.findByUserName(username).stream().toList();
        } else {
            users = userRepository.findByEmail(email).stream().toList();
        }
        return users.stream().map(user ->
                UserResponseDto.builder().username(user.getUserName())
                        .email(user.getEmail())
                        .name(user.getName())
                        .id(user.getId())
                        .build()).toList();
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userRepository.save(User.builder().userName(userRequestDto.getUsername()).email(userRequestDto.getEmail()).name(userRequestDto.getName()).build());
        return UserResponseDto.builder().username(user.getUserName()).email(user.getEmail()).name(user.getName()).id(user.getId()).build();
    }
}
