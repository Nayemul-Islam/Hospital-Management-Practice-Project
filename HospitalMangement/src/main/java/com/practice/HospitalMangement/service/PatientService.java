package com.practice.HospitalMangement.service;

import com.practice.HospitalMangement.dto.PatientDto;
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

    public Page<PatientDto> getPatients(String name, String email) {
        Page<Patient> patients;
        if (name == null && email == null) {
            patients = patientRepository.findAllPatients(PageRequest.of(0, 2));
        } else if (email != null) {
            patients = patientRepository.findByEmail(PageRequest.of(0, 2), email);
        } else {
            patients = patientRepository.findByName(PageRequest.of(0, 2), name);
        }
        return patients.map(patient -> PatientDto.builder().name(patient.getName()).email(patient.getEmail()).gender(patient.getGender()).dateOfBirth(patient.getDateOfBirth()).build());
    }

    public void addPatient(PatientDto patientDto) {

        patientRepository.save(Patient.builder().name(patientDto.getName()).email(patientDto.getEmail()).gender(patientDto.getGender()).dateOfBirth(patientDto.getDateOfBirth()).build());
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
