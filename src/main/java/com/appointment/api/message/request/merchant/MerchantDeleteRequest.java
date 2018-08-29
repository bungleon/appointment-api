package com.appointment.api.message.request.merchant;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MerchantDeleteRequest {
    private UUID id;
}
