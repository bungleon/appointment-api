package com.appointment.api.message.response.workinghour;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.WorkingHourDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkingHourListResponse extends BaseResponse {
    private List<WorkingHourDto> workingHours;

    @Builder
    public WorkingHourListResponse(ResponseCode responseCode, List<WorkingHourDto> workingHours) {
        super(responseCode);
        this.workingHours = workingHours;
    }
}
