package com.appointment.api.message.response.feedback;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.FeedBackBackendDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class FeedBackBackendListResponse extends BaseResponse {
    Page<FeedBackBackendDto> feedBackList;

    @Builder
    public FeedBackBackendListResponse(ResponseCode responseCode, Page<FeedBackBackendDto> feedBackList) {
        super(responseCode);
        this.feedBackList = feedBackList;
    }
}
