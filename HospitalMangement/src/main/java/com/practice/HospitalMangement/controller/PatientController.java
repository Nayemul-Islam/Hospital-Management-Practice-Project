package com.practice.HospitalMangement.controller;

import com.practice.HospitalMangement.entity.Patient;
import com.practice.HospitalMangement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getPatient() {
        return patientService.getPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientByID(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/name/{name}")
    public List<Patient> getPatientByName(@PathVariable String name) {
        return patientService.getPatientByName(name);
    }

    @GetMapping("/patients/keyword/{name}")
    public List<Patient> getPatientByNameContain(@PathVariable String name) {
        return patientService.getPatientByNameContain(name);
    }

    @GetMapping("/patients/email/{email}")
    public Patient getPatientByEmail(@PathVariable String email) {
        return patientService.getPatientByEmail(email);
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }
}
