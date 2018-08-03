package com.appointment.api.message.request.appointment;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AppointeeRequest {
    private UUID appointmentId;
}
