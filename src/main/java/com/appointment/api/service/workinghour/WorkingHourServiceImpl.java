package com.appointment.api.service.workinghour;

import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.domain.workinghour.WorkingHourRepository;
import com.appointment.api.exception.domain_exception.WorkingHourNotFoundException;
import com.appointment.api.exception.domain_exception.WorkingHourNotSavedException;
import com.appointment.api.message.TimePeriod;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkingHourServiceImpl implements WorkingHourService {
    private final WorkingHourRepository workingHourRepository;

    public WorkingHourServiceImpl(WorkingHourRepository workingHourRepository) {
        this.workingHourRepository = workingHourRepository;
    }

    @Override
    public WorkingHour save(WorkingHour workingHour) {
        return Optional.ofNullable(workingHourRepository.save(workingHour))
                .orElseThrow(WorkingHourNotSavedException::new);
    }

    @Override
    public WorkingHour getWorkingHourForSave(TimePeriod timePeriod, UUID merchantId, LocalDateTime today) {
        return Optional.ofNullable(workingHourRepository.findByTimePeriodAndMerchantIdAndToday(timePeriod, merchantId, today))
                .orElseThrow(WorkingHourNotFoundException::new);
    }
}
