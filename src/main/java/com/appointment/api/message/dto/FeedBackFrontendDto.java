package com.appointment.api.message.dto;

import com.appointment.api.domain.feedback.FeedBack;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackFrontendDto {
    private String header;
    private String content;
    private String commentator;

    public FeedBackFrontendDto(FeedBack feedBack) {
        this.header = feedBack.getHeader();
        this.content = feedBack.getContent();
        this.commentator = String.format("%s %s", feedBack.getUser().getFirstName(), feedBack.getUser().getLastName());
    }
}
