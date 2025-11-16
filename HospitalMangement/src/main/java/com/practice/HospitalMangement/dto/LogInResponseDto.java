package com.practice.HospitalMangement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogInResponseDto {
    private String jwtToken;
    private  Long userId;
}
