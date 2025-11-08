package com.practice.HospitalMangement.controller;

import com.practice.HospitalMangement.dto.PatientDto;
import com.practice.HospitalMangement.entity.Patient;
import com.practice.HospitalMangement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public Page<PatientDto> getPatient(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return patientService.getPatients(name, email);
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientByID(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/search")
    public List<Patient> getPatientByBornBefore(@RequestParam(name = "born-date-before", required = false) LocalDate birthDate) {
        return patientService.getPatientByBornBefore(birthDate);
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }
}
