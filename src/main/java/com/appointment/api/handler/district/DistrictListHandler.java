package com.appointment.api.handler.district;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.DistrictDto;
import com.appointment.api.message.request.district.DistrictListRequest;
import com.appointment.api.message.response.district.DistrictListResponse;
import com.appointment.api.service.district.DistrictService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictListHandler implements Handler<DistrictListRequest, DistrictListResponse> {
    private final DistrictService districtService;

    public DistrictListHandler(DistrictService districtService) {
        this.districtService = districtService;
    }

    @Override
    public DistrictListResponse execute(DistrictListRequest request) {
        List<DistrictDto> districtDtos = districtService.getByTownId(request.getTownId())
                .stream()
                .map(DistrictDto::new)
                .collect(Collectors.toList());

        return DistrictListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .districts(districtDtos)
                .build();
    }
}
