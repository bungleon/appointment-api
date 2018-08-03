package com.appointment.api.message.request.merchant;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
public class SetMerchantHolidayRequest {
    @NotNull
    private String apiKey;
    private DayOfWeek day;
    private String date;
}
