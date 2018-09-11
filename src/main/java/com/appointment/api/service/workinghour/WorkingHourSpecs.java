package com.appointment.api.service.workinghour;

import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.helper.Helper;
import com.appointment.api.message.request.workinghour.WorkingHourListRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkingHourSpecs implements Specification<WorkingHour> {
    private final WorkingHourListRequest request;

    public WorkingHourSpecs(WorkingHourListRequest request) {
        this.request = request;
    }

    @Override
    public Specification<WorkingHour> and(Specification<WorkingHour> other) {
        return null;
    }

    @Override
    public Specification<WorkingHour> or(Specification<WorkingHour> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<WorkingHour> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isEmpty(request.getApiKey())) {
            Path<Merchant> merchantPath = root.get("merchant");
            predicates.add(cb.and(cb.equal(merchantPath.get("apiKey"), request.getApiKey())));
        }
        LocalDateTime fromDate = LocalDateTime.MIN;
        LocalDateTime toDate = LocalDateTime.MAX;
        if (!StringUtils.isEmpty(request.getFromDate())) {
            fromDate = Helper.getToday(request.getFromDate());
        }

        if (!StringUtils.isEmpty(request.getFromDate())) {
            toDate = Helper.getToday(request.getToDate());
        }
        predicates.add(cb.and(cb.between(root.get("today"), fromDate, toDate)));
        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
