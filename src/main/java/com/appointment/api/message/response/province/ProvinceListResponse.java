package com.appointment.api.message.response.province;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.ProvinceDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProvinceListResponse extends BaseResponse {
    private List<ProvinceDto> provinces;

    @Builder
    public ProvinceListResponse(ResponseCode responseCode, List<ProvinceDto> provinces) {
        super(responseCode);
        this.provinces = provinces;
    }
}
