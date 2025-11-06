package com.practice.HospitalMangement.service;

import com.practice.HospitalMangement.entity.Patient;
import com.practice.HospitalMangement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    public final PatientRepository patientRepository;

    public Page<Patient> getPatients(String name, String email) {
        if (name == null && email == null)
            return patientRepository.findAllPatients(PageRequest.of(0, 2));
        else if (email != null)
            return patientRepository.findByEmail(PageRequest.of(0, 2), email);
        else
            return patientRepository.findByName(PageRequest.of(0, 2), name);
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }


//    public List<Patient> getPatientByNameContain(String name) {
//        return patientRepository.findByNameContaining(PageRequest.of(0,2),name);
//    }


    public List<Patient> getPatientByBornBefore(LocalDate birthDate) {
        return patientRepository.findByBornBefore(birthDate);
    }
}
