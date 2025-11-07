package com.practice.HospitalMangement.controller;

import com.practice.HospitalMangement.entity.Department;
import com.practice.HospitalMangement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {

        return departmentService.getAllDepartments();
    }
    @PostMapping("/")
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

}
