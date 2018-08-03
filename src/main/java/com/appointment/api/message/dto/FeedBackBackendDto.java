package com.appointment.api.message.dto;

import com.appointment.api.domain.feedback.FeedBack;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FeedBackBackendDto {
    private UUID id;
    private String header;
    private String content;

    public FeedBackBackendDto(FeedBack feedBack) {
        this.id = feedBack.getId();
        this.header = feedBack.getHeader();
        this.content = feedBack.getContent();
    }
}
