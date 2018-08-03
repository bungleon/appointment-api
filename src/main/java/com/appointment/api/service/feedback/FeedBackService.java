package com.appointment.api.service.feedback;

import com.appointment.api.domain.feedback.FeedBack;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface FeedBackService {
    FeedBack create(FeedBack feedBack);

    FeedBack update(FeedBack feedBack);

    Page<FeedBack> pageList(UUID merchantId, Integer pageNumber);

    FeedBack detail(UUID id);

    FeedBack confirm(UUID id);

}
