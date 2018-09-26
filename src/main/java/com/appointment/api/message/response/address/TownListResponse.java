package com.appointment.api.message.response.address;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.TownDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TownListResponse extends BaseResponse {
    private List<TownDto> towns;

    @Builder
    public TownListResponse(ResponseCode responseCode, List<TownDto> towns) {
        super(responseCode);
        this.towns = towns;
    }
}
