package com.practice.HospitalMangement.security;

import com.practice.HospitalMangement.dto.LogInRequestDto;
import com.practice.HospitalMangement.dto.LogInResponseDto;
import com.practice.HospitalMangement.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public LogInResponseDto login(LogInRequestDto logInRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(logInRequestDto.getUsername(), logInRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();

        String token = authUtil.getJwtToken(user);
        System.out.println("token: " + token);
        return new LogInResponseDto(token, user.getId());
    }
}
