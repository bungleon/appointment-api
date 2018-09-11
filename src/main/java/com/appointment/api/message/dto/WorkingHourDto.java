package com.appointment.api.message.dto;

import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.message.TimePeriod;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class WorkingHourDto {
    private UUID id;
    private TimePeriod timePeriod;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private LocalDateTime today;
    private String apiKey;
    private String merchantName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public WorkingHourDto(WorkingHour workingHour) {
        this.id = workingHour.getId();
        this.timePeriod = workingHour.getTimePeriod();
        this.startTime = workingHour.getStartTime();
        this.finishTime = workingHour.getFinishTime();
        this.today = workingHour.getToday();
        this.apiKey = workingHour.getMerchant().getApiKey();
        this.merchantName = workingHour.getMerchant().getName();
        this.createDate = workingHour.getCreateDate();
        this.updateDate = workingHour.getUpdateDate();
    }
}
