package com.appointment.api.message.request.feedback;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FeedBackCreateRequest {
    private UUID merchantId;
    private UUID appointmentId;
    private String header;
    private String content;
}
