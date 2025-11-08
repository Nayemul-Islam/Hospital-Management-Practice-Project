package com.practice.HospitalMangement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private String name;
    private String email;
    private String gender;
    private LocalDate dateOfBirth;
}