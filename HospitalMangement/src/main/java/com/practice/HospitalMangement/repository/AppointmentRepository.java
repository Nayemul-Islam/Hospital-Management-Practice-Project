package com.practice.HospitalMangement.repository;

import com.practice.HospitalMangement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}