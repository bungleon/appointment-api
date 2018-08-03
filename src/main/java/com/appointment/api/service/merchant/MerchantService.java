package com.appointment.api.service.merchant;

import com.appointment.api.domain.merchant.Holiday;
import com.appointment.api.domain.merchant.Merchant;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface MerchantService {
    Merchant add(Merchant merchant);

    Merchant update(Merchant merchant);

    Merchant getById(UUID id);

    List<Merchant> getMerchantList();

    Merchant getByApiKey(String apiKey);

    Merchant setHoliday(DayOfWeek day, String apiKey, LocalDateTime date);

    List<Holiday> getHolidays(UUID merchantId);
}
