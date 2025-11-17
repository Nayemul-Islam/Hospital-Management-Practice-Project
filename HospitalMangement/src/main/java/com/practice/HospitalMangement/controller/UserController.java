package com.practice.HospitalMangement.controller;

import com.practice.HospitalMangement.dto.UserRequestDto;
import com.practice.HospitalMangement.dto.UserResponseDto;
import com.practice.HospitalMangement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserResponseDto> getUser(@RequestParam(required = false) String username, @RequestParam(required = false) String email) {
        return userService.getUser(username, email);
    }

    @PostMapping("/auth/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);

    }

}
