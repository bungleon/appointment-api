package com.appointment.api.message.response.feedback;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.FeedBackFrontendDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class FeedBackFrontendListResponse extends BaseResponse {
    private Page<FeedBackFrontendDto> feedBacks;

    @Builder
    public FeedBackFrontendListResponse(ResponseCode responseCode, Page<FeedBackFrontendDto> feedBacks) {
        super(responseCode);
        this.feedBacks = feedBacks;
    }
}
