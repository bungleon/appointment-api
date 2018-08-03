package com.appointment.api.message.request.merchant;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class MerchantUpdateRequest {
    @NotNull
    private UUID id;
    @NotEmpty
    private String apiKey;
    @NotEmpty
    private String secretKey;
    @NotEmpty
    private String name;
    private Integer workingRange;
    private Boolean enabled = true;
}
