package com.appointment.api.controller;

import com.appointment.api.handler.appointment.AppointeeHandler;
import com.appointment.api.handler.appointment.AppointmentListHandler;
import com.appointment.api.message.request.appointment.AppointeeRequest;
import com.appointment.api.message.request.appointment.AppointmentListRequest;
import com.appointment.api.message.response.appointment.AppointeeResponse;
import com.appointment.api.message.response.appointment.AppointmentListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    private final AppointmentListHandler appointmentListHandler;
    private final AppointeeHandler appointeeHandler;

    public AppointmentController(AppointmentListHandler appointmentListHandler, AppointeeHandler appointeeHandler) {
        this.appointmentListHandler = appointmentListHandler;
        this.appointeeHandler = appointeeHandler;
    }

    @PostMapping("/list")
    public AppointmentListResponse list(@RequestBody AppointmentListRequest request) {
        return appointmentListHandler.execute(request);
    }

    @PostMapping("/appointee")
    public AppointeeResponse appointee(@RequestBody AppointeeRequest request) {
        return appointeeHandler.execute(request);
    }
}
