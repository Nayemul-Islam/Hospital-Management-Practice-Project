package com.practice.HospitalMangement.repository;

import com.practice.HospitalMangement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}