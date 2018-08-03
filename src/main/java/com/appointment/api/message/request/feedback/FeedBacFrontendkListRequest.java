package com.appointment.api.message.request.feedback;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FeedBacFrontendkListRequest {
    private UUID merchantId;
    private Integer pageNumber;
}
