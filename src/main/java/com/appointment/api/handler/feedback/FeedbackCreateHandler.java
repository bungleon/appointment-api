package com.appointment.api.handler.feedback;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.appointment.Appointment;
import com.appointment.api.domain.feedback.FeedBack;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.domain.user.User;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.feedback.FeedBackCreateRequest;
import com.appointment.api.message.response.feedback.FeedBackCreateResponse;
import com.appointment.api.service.appointment.AppointmentService;
import com.appointment.api.service.feedback.FeedBackService;
import com.appointment.api.service.merchant.MerchantService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FeedbackCreateHandler implements Handler<FeedBackCreateRequest, FeedBackCreateResponse> {
    private final FeedBackService feedBackService;
    private final MerchantService merchantService;
    private final AppointmentService appointmentService;
    private final AuthUser authUser;

    public FeedbackCreateHandler(FeedBackService feedBackService, MerchantService merchantService,
                                 AppointmentService appointmentService, AuthUser authUser) {
        this.feedBackService = feedBackService;
        this.merchantService = merchantService;
        this.appointmentService = appointmentService;
        this.authUser = authUser;
    }

    @Override
    public FeedBackCreateResponse execute(FeedBackCreateRequest request) {
        FeedBack feedBack = new FeedBack();
        Appointment appointment = null;

        Merchant merchant = merchantService.getById(request.getMerchantId());
        User user = authUser.getUser();
        if (Objects.nonNull(request.getAppointmentId())) {
            appointment = appointmentService.getById(request.getAppointmentId());
        }

        feedBack.setAppointment(appointment);
        feedBack.setMerchant(merchant);
        feedBack.setUser(user);
        feedBack.setHeader(request.getHeader());
        feedBack.setContent(request.getContent());
        feedBack.setEnabled(true);

        feedBackService.create(feedBack);

        return FeedBackCreateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
