package com.appointment.api.service.feedback;

import com.appointment.api.domain.feedback.FeedBack;
import com.appointment.api.domain.feedback.FeedBackRepository;
import com.appointment.api.exception.domain_exception.FeedBackCannotCreatedException;
import com.appointment.api.exception.domain_exception.FeedBackNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    private static final int PAGE_SIZE = 25;
    private final FeedBackRepository feedBackRepository;

    public FeedBackServiceImpl(FeedBackRepository feedBackRepository) {
        this.feedBackRepository = feedBackRepository;
    }

    @Override
    public FeedBack create(FeedBack feedBack) {
        return Optional.ofNullable(feedBackRepository.save(feedBack))
                .orElseThrow(FeedBackCannotCreatedException::new);
    }

    @Override
    public FeedBack update(FeedBack feedBack) {
        return null;
    }

    @Override
    public Page<FeedBack> pageList(UUID merchantId, Integer pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "createDate");
        return feedBackRepository.findAllByMerchantIdAndEnabledTrueAndConfirmationTrueAndDeletedFalse(merchantId, pageRequest);
    }

    @Override
    public FeedBack detail(UUID id) {
        return null;
    }

    @Override
    public FeedBack confirm(UUID id) {
        return Optional.ofNullable(feedBackRepository.getById(id))
                .orElseThrow(FeedBackNotFoundException::new);
    }

}
