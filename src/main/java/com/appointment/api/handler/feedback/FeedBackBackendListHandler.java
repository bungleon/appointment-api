package com.appointment.api.handler.feedback;

import com.appointment.api.domain.feedback.FeedBack;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.FeedBackBackendDto;
import com.appointment.api.message.request.feedback.FeedBackBackendListRequest;
import com.appointment.api.message.response.feedback.FeedBackBackendListResponse;
import com.appointment.api.service.feedback.FeedBackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeedBackBackendListHandler implements Handler<FeedBackBackendListRequest, FeedBackBackendListResponse> {
    private final FeedBackService feedBackService;
    private static final Integer PAGE_SIZE = 25;

    public FeedBackBackendListHandler(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @Override
    public FeedBackBackendListResponse execute(FeedBackBackendListRequest request) {
        Page<FeedBack> feedBacks = feedBackService.pageList(request.getMerchantId(),
                request.getPageNumber() == null ? 1 : request.getPageNumber());

        List<FeedBackBackendDto> feedBackFrontendDtos = feedBacks.getContent().stream()
                .map(FeedBackBackendDto::new).collect(Collectors.toList());

        PageRequest pageRequest = new PageRequest(request.getPageNumber() == null || request.getPageNumber() < 0 ? 0 : request.getPageNumber() - 1,
                PAGE_SIZE);

        return FeedBackBackendListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .feedBackList(new PageImpl<>(feedBackFrontendDtos, pageRequest, feedBacks.getTotalElements()))
                .build();
    }
}
