package com.appointment.api.message.request.workinghour;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkingHourListRequest {
    private String apiKey;
    private String fromDate;
    private String toDate;
}
