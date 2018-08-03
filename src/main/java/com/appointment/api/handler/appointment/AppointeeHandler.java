package com.appointment.api.handler.appointment;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.appointment.AppointeeRequest;
import com.appointment.api.message.response.appointment.AppointeeResponse;
import com.appointment.api.service.appointment.AppointmentService;
import org.springframework.stereotype.Component;

@Component
public class AppointeeHandler implements Handler<AppointeeRequest, AppointeeResponse> {
    private final AppointmentService appointmentService;

    public AppointeeHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public AppointeeResponse execute(AppointeeRequest request) {
        appointmentService.appointee(request.getAppointmentId());

        return AppointeeResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
