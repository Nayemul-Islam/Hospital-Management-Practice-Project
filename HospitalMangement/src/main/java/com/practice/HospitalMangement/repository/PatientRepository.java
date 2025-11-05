package com.practice.HospitalMangement.repository;

import com.practice.HospitalMangement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String name);

    List<Patient> findByNameContaining(String name);

    List<Patient> findByEmail(String email);

    List<Patient> findByDateOfBirth(LocalDate birthDate);

    @Query(
            "select p from Patient p where p.dateOfBirth < :dateOfBirth"
    )
    List<Patient> findByBornBefore(@Param("dateOfBirth") LocalDate birthDate);

}
