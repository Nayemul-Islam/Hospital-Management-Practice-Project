package com.practice.HospitalMangement.service;

import com.practice.HospitalMangement.entity.Department;
import com.practice.HospitalMangement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }
}
