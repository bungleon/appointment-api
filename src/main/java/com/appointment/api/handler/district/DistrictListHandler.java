package com.appointment.api.handler.district;

import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.district.DistrictListRequest;
import com.appointment.api.message.response.district.DistrictListResponse;
import org.springframework.stereotype.Component;

@Component
public class DistrictListHandler implements Handler<DistrictListRequest,DistrictListResponse> {
    @Override
    public DistrictListResponse execute(DistrictListRequest request) {
        return null;
    }
}
