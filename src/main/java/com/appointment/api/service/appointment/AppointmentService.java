package com.appointment.api.service.appointment;

import com.appointment.api.domain.appointment.Appointment;
import com.appointment.api.domain.workinghour.WorkingHour;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    void createAppointment(Integer range, WorkingHour workingHour);

    List<Appointment> getByWorkingHours(UUID workingHourId);

    void deleteAppointment(UUID workingHourId);

    Appointment appointee(UUID id);

    Appointment save(Appointment appointment);

    Appointment getById(UUID id);
}
