package com.appointment.api.handler.province;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.ProvinceDto;
import com.appointment.api.message.request.province.ProvinceListRequest;
import com.appointment.api.message.response.province.ProvinceListResponse;
import com.appointment.api.service.province.ProvinceService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinceListHandler implements Handler<ProvinceListRequest, ProvinceListResponse> {
    private final ProvinceService provinceService;

    public ProvinceListHandler(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public ProvinceListResponse execute(ProvinceListRequest request) {
        List<ProvinceDto> provinceDtoList = provinceService.getByCountryId(request.getCountryId()).stream()
                .map(ProvinceDto::new)
                .sorted(Comparator.comparing(x -> Integer.valueOf(x.getPlateNumber())))
                .collect(Collectors.toList());

        return ProvinceListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .provinces(provinceDtoList)
                .build();
    }
}
