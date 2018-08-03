package com.appointment.api.domain.merchant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    Merchant findByIdAndDeletedFalse(UUID id);
    Merchant findByApiKey(String apiKey);
    List<Merchant> findAllByDeletedFalseAndEnabledTrue();
}
