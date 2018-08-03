package com.appointment.api.message.request.workinghour;

import com.appointment.api.message.TimePeriod;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WorkingHourUpdateRequest {
    @NotEmpty
    private String apiKey;
    @NotEmpty
    private String date;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String finishTime;
    @NotNull
    private TimePeriod timePeriod;
}
