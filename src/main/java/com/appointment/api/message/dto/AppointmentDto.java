package com.appointment.api.message.dto;

import com.appointment.api.domain.appointment.Appointment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class AppointmentDto {
    private UUID id;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private Boolean appointee = false;
    private UUID appointeeId;

    public AppointmentDto(Appointment appointment) {
        this.id=appointment.getId();
        this.startTime = appointment.getStartTime();
        this.finishTime = appointment.getFinishTime();
        if (Objects.nonNull(appointment.getAppointee())) {
            this.appointee = true;
            this.appointeeId=appointment.getAppointee().getId();
        }
    }
}
