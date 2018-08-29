package com.appointment.api.message.request.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDeleteRequest {
    private UUID id;
}
