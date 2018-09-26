package com.appointment.api.message.request.province;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProvinceListRequest {
    private UUID countryId;
}
