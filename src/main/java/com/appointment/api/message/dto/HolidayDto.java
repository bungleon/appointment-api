package com.appointment.api.message.dto;

import com.appointment.api.domain.merchant.Holiday;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
@Setter
public class HolidayDto {
    private DayOfWeek day;
    private LocalDateTime date;

    public HolidayDto(Holiday holiday) {
        this.day=holiday.getDay();
        this.date=holiday.getSpecificDay();
    }
}
