package com.appointment.api.service.appointment;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.appointment.Appointment;
import com.appointment.api.domain.appointment.AppointmentRepository;
import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.exception.domain_exception.AppointmentTakenBefore;
import com.appointment.api.exception.domain_exception.AppointmentsAlreadyExistException;
import com.appointment.api.exception.domain_exception.TimeException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AuthUser authUser;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AuthUser authUser) {
        this.appointmentRepository = appointmentRepository;
        this.authUser = authUser;
    }

    @Override
    public void createAppointment(Integer range, WorkingHour workingHour) {
        List<Appointment> appointments = getByWorkingHours(workingHour.getId());
        if (!CollectionUtils.isEmpty(appointments)) {
            throw new AppointmentsAlreadyExistException();
        }
        long minutes = workingHour.getStartTime().until(workingHour.getFinishTime(), ChronoUnit.MINUTES);
        long appointmentCount = minutes / (long) range;

        LocalDateTime startTime = workingHour.getStartTime();
        for (int i = 0; i < appointmentCount; i++) {
            Appointment appointment = new Appointment();
            appointment.setStartTime(startTime);
            appointment.setFinishTime(startTime.plusMinutes((long) range));
            appointment.setUser(authUser.getUser());
            appointment.setWorkingHour(workingHour);
            appointmentRepository.save(appointment);

            startTime = startTime.plusMinutes((long) range);

        }
    }

    @Override
    public List<Appointment> getByWorkingHours(UUID workingHourId) {
        return appointmentRepository.findAllByWorkingHourIdAndDeletedFalse(workingHourId);
    }

    @Override
    public void deleteAppointment(UUID workingHourId) {
        List<Appointment> appointments = appointmentRepository.findAllByWorkingHourIdAndDeletedFalse(workingHourId);
        for (Appointment appointment : appointments) {
            appointment.markAsDeleted();
            appointmentRepository.save(appointment);
        }
    }

    @Override
    public Appointment appointee(UUID id) {
        Appointment appointment = appointmentRepository.findByIdAndDeletedFalse(id);
        if (appointment.getFinishTime().isBefore(LocalDateTime.now())) {
            throw new TimeException();
        }
        if (appointment.getAppointee() != null) {
            throw new AppointmentTakenBefore();
        }
        appointment.setAppointee(authUser.getUser());
        return save(appointment);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getById(UUID id) {
        return null;
    }


}
