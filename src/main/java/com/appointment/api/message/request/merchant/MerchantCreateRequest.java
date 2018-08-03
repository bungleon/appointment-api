package com.appointment.api.message.request.merchant;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MerchantCreateRequest {
    @NotEmpty
    private String apiKey;
    @NotEmpty
    private String secretKey;
    @NotEmpty
    private String name;
    private Integer workingRange;
    private Boolean enabled = true;
}
