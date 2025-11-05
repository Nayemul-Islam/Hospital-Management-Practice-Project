package com.practice.HospitalMangement.service;

import com.practice.HospitalMangement.entity.Patient;
import com.practice.HospitalMangement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    public final PatientRepository patientRepository;

    public List<Patient> getPatients(String name, String email) {
        if (name == null && email == null)
            return patientRepository.findAll();
        else if (email != null)
            return patientRepository.findByEmail(email);
        else
            return patientRepository.findByName(name);
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }


    public List<Patient> getPatientByNameContain(String name) {
        return patientRepository.findByNameContaining(name);
    }


    public List<Patient> getPatientByBornBefore(LocalDate birthDate) {
        return patientRepository.findByBornBefore(birthDate);
    }
}
