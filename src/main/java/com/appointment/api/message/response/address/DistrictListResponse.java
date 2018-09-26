package com.appointment.api.message.response.address;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.DistrictDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictListResponse extends BaseResponse {
    List<DistrictDto> districts;

    @Builder
    public DistrictListResponse(ResponseCode responseCode, List<DistrictDto> districts) {
        super(responseCode);
        this.districts = districts;
    }
}
