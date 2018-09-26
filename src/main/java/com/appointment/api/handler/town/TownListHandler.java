package com.appointment.api.handler.town;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.TownDto;
import com.appointment.api.message.request.town.TownListRequest;
import com.appointment.api.message.response.town.TownListResponse;
import com.appointment.api.service.town.TownService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TownListHandler implements Handler<TownListRequest, TownListResponse> {
    private final TownService townService;

    public TownListHandler(TownService townService) {
        this.townService = townService;
    }

    @Override
    public TownListResponse execute(TownListRequest request) {
        List<TownDto> townDtos = townService.getByProvinceId(request.getProvinceId()).stream()
                .map(TownDto::new)
                .collect(Collectors.toList());

        return TownListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .towns(townDtos)
                .build();
    }
}
