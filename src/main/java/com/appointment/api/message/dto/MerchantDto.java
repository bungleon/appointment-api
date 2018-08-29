package com.appointment.api.message.dto;

import com.appointment.api.domain.merchant.Merchant;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MerchantDto {
    private UUID id;
    private String name;
    private String apiKey;
    private String secretKey;
    private Integer workingRange;
    private Boolean enabled;
    private UUID whoCreatedId;
    private String whoCreated;
    private LocalDateTime created;
    private LocalDateTime updated;

    public MerchantDto(Merchant merchant) {
        this.id = merchant.getId();
        this.name = merchant.getName();
        this.apiKey = merchant.getApiKey();
        this.secretKey = merchant.getSecretKey();
        this.workingRange = merchant.getWorkingRange();
        this.enabled = merchant.isEnabled();
        this.created = merchant.getCreateDate();
        this.updated = merchant.getUpdateDate();
        this.whoCreatedId = merchant.getUser().getId();
        this.whoCreated = String.format("%s %s", merchant.getUser().getFirstName(), merchant.getUser().getLastName());
    }
}
