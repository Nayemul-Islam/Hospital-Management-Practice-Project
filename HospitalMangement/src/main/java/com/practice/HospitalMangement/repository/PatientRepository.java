package com.practice.HospitalMangement.repository;

import com.practice.HospitalMangement.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByName(Pageable pageable, String name);

    Page<Patient> findByNameContaining(Pageable pageable, String name);

    Page<Patient> findByEmail(Pageable pageable, String email);

    List<Patient> findByDateOfBirth(LocalDate birthDate);

    @Query(
            "select p from Patient p where p.dateOfBirth < :dateOfBirth"
    )
    List<Patient> findByBornBefore(@Param("dateOfBirth") LocalDate birthDate);

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);
}
