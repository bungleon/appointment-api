package com.appointment.api.handler.feedback;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.feedback.FeedBackConfirmationRequest;
import com.appointment.api.message.response.feedback.FeedBackConfirmationResponse;
import com.appointment.api.service.feedback.FeedBackService;
import org.springframework.stereotype.Component;

@Component
public class ConfirmFeedBack implements Handler<FeedBackConfirmationRequest, FeedBackConfirmationResponse> {
    private final FeedBackService feedBackService;

    public ConfirmFeedBack(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @Override
    public FeedBackConfirmationResponse execute(FeedBackConfirmationRequest request) {
        feedBackService.confirm(request.getId());

        return FeedBackConfirmationResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
