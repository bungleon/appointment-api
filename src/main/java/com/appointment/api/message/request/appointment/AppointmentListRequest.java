package com.appointment.api.message.request.appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentListRequest {
    private String apiKey;
    private String date;
}
