package com.appointment.api.domain.merchant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HolidayRepository extends JpaRepository<Holiday, UUID> {
    List<Holiday> findAllByMerchantIdAndEnabledTrueAndDeletedFalse(UUID merchantId);
}
