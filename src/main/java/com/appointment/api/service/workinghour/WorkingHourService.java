package com.appointment.api.service.workinghour;

import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.message.TimePeriod;

import java.time.LocalDateTime;
import java.util.UUID;

public interface WorkingHourService {
    WorkingHour save(WorkingHour workingHour);

    WorkingHour getWorkingHourForSave(TimePeriod timePeriod, UUID merchantId, LocalDateTime today);
}
