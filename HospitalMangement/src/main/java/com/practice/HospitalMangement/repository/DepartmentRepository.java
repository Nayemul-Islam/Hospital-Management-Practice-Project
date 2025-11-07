package com.practice.HospitalMangement.repository;

import com.practice.HospitalMangement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}