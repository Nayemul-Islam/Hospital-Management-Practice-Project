package com.practice.HospitalMangement.repository;

import com.practice.HospitalMangement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}