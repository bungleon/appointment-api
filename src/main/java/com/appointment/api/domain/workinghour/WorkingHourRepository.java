package com.appointment.api.domain.workinghour;

import com.appointment.api.message.TimePeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface WorkingHourRepository extends JpaRepository<WorkingHour, UUID> {
    WorkingHour findByTimePeriodAndMerchantIdAndToday(TimePeriod timePeriod, UUID merchantId, LocalDateTime today);
}
