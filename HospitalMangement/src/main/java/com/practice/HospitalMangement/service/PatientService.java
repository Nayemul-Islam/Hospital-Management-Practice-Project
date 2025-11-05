package com.practice.HospitalMangement.service;

import com.practice.HospitalMangement.entity.Patient;
import com.practice.HospitalMangement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    public final PatientRepository patientRepository;

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    public List<Patient> getPatientByName(String name) {
        return patientRepository.findByName(name);
    }

    public List<Patient> getPatientByNameContain(String name) {
        return patientRepository.findByNameContaining(name);
    }

    public Patient getPatientByEmail(String email) {
        return  patientRepository.findByEmail(email);
    }
}
