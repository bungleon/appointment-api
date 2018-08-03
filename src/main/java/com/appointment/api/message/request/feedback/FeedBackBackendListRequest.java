package com.appointment.api.message.request.feedback;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FeedBackBackendListRequest {
    private UUID merchantId;
    private Integer pageNumber;
}
