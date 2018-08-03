package com.appointment.api.controller;

import com.appointment.api.handler.workinghour.WorkingHourUpdateHandler;
import com.appointment.api.message.request.workinghour.WorkingHourUpdateRequest;
import com.appointment.api.message.response.workinghour.WorkingHourUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/work-hour")
public class WorkingHourController {
    private final WorkingHourUpdateHandler workingHourUpdateHandler;

    public WorkingHourController(WorkingHourUpdateHandler workingHourUpdateHandler) {
        this.workingHourUpdateHandler = workingHourUpdateHandler;
    }

    @PostMapping("/update")
    public WorkingHourUpdateResponse update(@RequestBody WorkingHourUpdateRequest request) {
        return workingHourUpdateHandler.execute(request);
    }
}
