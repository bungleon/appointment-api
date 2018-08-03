package com.appointment.api.domain.feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FeedBackRepository extends JpaRepository<FeedBack, UUID> {
    Page<FeedBack> findAllByMerchantIdAndEnabledTrueAndConfirmationTrueAndDeletedFalse(UUID merchantId, Pageable pageable);

    Long countAllByMerchantIdAndEnabledTrueAndConfirmationTrueAndDeletedFalse(UUID merchantId);

    FeedBack getById(UUID id);
}
