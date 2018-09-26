package com.appointment.api.message.request.address;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DistrictListRequest {
    private UUID townId;
}
