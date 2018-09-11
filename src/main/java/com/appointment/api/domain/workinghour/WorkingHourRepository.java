package com.appointment.api.domain.workinghour;

import com.appointment.api.message.TimePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface WorkingHourRepository extends JpaRepository<WorkingHour, UUID>, JpaSpecificationExecutor<WorkingHour> {
    WorkingHour findByTimePeriodAndMerchantIdAndToday(TimePeriod timePeriod, UUID merchantId, LocalDateTime today);

    List<WorkingHour> findByMerchantApiKeyAndToday(String apiKey, LocalDateTime today);
}
