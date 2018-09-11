package com.appointment.api.handler.workinghour;

import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.WorkingHourDto;
import com.appointment.api.message.request.workinghour.WorkingHourListRequest;
import com.appointment.api.message.response.workinghour.WorkingHourListResponse;
import com.appointment.api.service.workinghour.WorkingHourService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingHourListHandler implements Handler<WorkingHourListRequest, WorkingHourListResponse> {
    private final WorkingHourService workingHourService;

    public WorkingHourListHandler(WorkingHourService workingHourService) {
        this.workingHourService = workingHourService;
    }

    @Override
    public WorkingHourListResponse execute(WorkingHourListRequest request) {
        List<WorkingHour> workingHour = workingHourService.search(request);
        List<WorkingHourDto> workingHours = workingHour.stream().map(WorkingHourDto::new)
                .collect(Collectors.toList());

        return WorkingHourListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .workingHours(workingHours)
                .build();
    }
}
