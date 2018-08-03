package com.appointment.api.controller;

import com.appointment.api.handler.feedback.ConfirmFeedBack;
import com.appointment.api.handler.feedback.FeedBackBackendListHandler;
import com.appointment.api.handler.feedback.FeedBackFrontendListHandler;
import com.appointment.api.handler.feedback.FeedbackCreateHandler;
import com.appointment.api.message.request.feedback.FeedBacFrontendkListRequest;
import com.appointment.api.message.request.feedback.FeedBackBackendListRequest;
import com.appointment.api.message.request.feedback.FeedBackConfirmationRequest;
import com.appointment.api.message.request.feedback.FeedBackCreateRequest;
import com.appointment.api.message.response.feedback.FeedBackBackendListResponse;
import com.appointment.api.message.response.feedback.FeedBackConfirmationResponse;
import com.appointment.api.message.response.feedback.FeedBackCreateResponse;
import com.appointment.api.message.response.feedback.FeedBackFrontendListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedBackController {
    private final FeedbackCreateHandler feedbackCreateHandler;
    private final FeedBackFrontendListHandler feedBackFrontendListHandler;
    private final FeedBackBackendListHandler feedBackBackendListHandler;
    private final ConfirmFeedBack confirmFeedBack;

    public FeedBackController(FeedbackCreateHandler feedbackCreateHandler,
                              FeedBackFrontendListHandler feedBackFrontendListHandler,
                              FeedBackBackendListHandler feedBackBackendListHandler, ConfirmFeedBack confirmFeedBack) {
        this.feedbackCreateHandler = feedbackCreateHandler;
        this.feedBackFrontendListHandler = feedBackFrontendListHandler;
        this.feedBackBackendListHandler = feedBackBackendListHandler;
        this.confirmFeedBack = confirmFeedBack;
    }

    @PostMapping("/create")
    public FeedBackCreateResponse create(@RequestBody FeedBackCreateRequest request) {
        return feedbackCreateHandler.execute(request);
    }

    @PostMapping("/list")
    public FeedBackFrontendListResponse list(@RequestBody FeedBacFrontendkListRequest request) {
        return feedBackFrontendListHandler.execute(request);
    }

    @PostMapping("/list/backend")
    public FeedBackBackendListResponse backendList(@RequestBody FeedBackBackendListRequest request) {
        return feedBackBackendListHandler.execute(request);
    }

    @PostMapping("/confirm")
    public FeedBackConfirmationResponse confirmation(@RequestBody FeedBackConfirmationRequest request) {
        return confirmFeedBack.execute(request);
    }
}
