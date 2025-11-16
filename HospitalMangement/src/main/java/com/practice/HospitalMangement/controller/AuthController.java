package com.practice.HospitalMangement.controller;

import com.practice.HospitalMangement.dto.LogInRequestDto;
import com.practice.HospitalMangement.dto.LogInResponseDto;
import com.practice.HospitalMangement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LogInResponseDto> login(@RequestBody LogInRequestDto logInRequestDto){

        return ResponseEntity.ok(authService.login(logInRequestDto));
    }
}
