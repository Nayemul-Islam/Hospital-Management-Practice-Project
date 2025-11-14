package com.practice.HospitalMangement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String name;
    private String username;
    private String email;
}
