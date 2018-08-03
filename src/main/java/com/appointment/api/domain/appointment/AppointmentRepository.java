package com.appointment.api.domain.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAllByWorkingHourIdAndDeletedFalse(UUID workingHourId);
    Appointment findByIdAndDeletedFalse(UUID id);
}
