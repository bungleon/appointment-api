package com.appointment.api.controller;

import com.appointment.api.handler.workinghour.WorkingHourListHandler;
import com.appointment.api.handler.workinghour.WorkingHourUpdateHandler;
import com.appointment.api.message.Deneme;
import com.appointment.api.message.request.workinghour.WorkingHourListRequest;
import com.appointment.api.message.request.workinghour.WorkingHourUpdateRequest;
import com.appointment.api.message.response.workinghour.WorkingHourListResponse;
import com.appointment.api.message.response.workinghour.WorkingHourUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/work-hour")
public class WorkingHourController {
    private final WorkingHourUpdateHandler workingHourUpdateHandler;
    private final WorkingHourListHandler workingHourListHandler;

    public WorkingHourController(WorkingHourUpdateHandler workingHourUpdateHandler,
                                 WorkingHourListHandler workingHourListHandler) {
        this.workingHourUpdateHandler = workingHourUpdateHandler;
        this.workingHourListHandler = workingHourListHandler;
    }

    @PostMapping("/update")
    public WorkingHourUpdateResponse update(@RequestBody WorkingHourUpdateRequest request) {
        return workingHourUpdateHandler.execute(request);
    }

    @PostMapping("/list")
    public WorkingHourListResponse list(@RequestBody WorkingHourListRequest request) {
        return workingHourListHandler.execute(request);
    }
}
