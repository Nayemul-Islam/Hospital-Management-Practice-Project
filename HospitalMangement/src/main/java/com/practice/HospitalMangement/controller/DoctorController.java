package com.practice.HospitalMangement.controller;

import com.practice.HospitalMangement.entity.Doctor;
import com.practice.HospitalMangement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @PostMapping("/")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);

    }


}
