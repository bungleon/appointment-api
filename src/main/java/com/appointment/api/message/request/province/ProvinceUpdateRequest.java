package com.appointment.api.message.request.province;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProvinceUpdateRequest {
    private UUID id;
    private String name;
    private String code;
    private String phoneCode;
}
