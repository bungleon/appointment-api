package com.appointment.api.message.response.address;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.AddressDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddressListResponse extends BaseResponse {
    private List<AddressDto> addresses;

    @Builder
    public AddressListResponse(ResponseCode responseCode, List<AddressDto> addresses) {
        super(responseCode);
        this.addresses = addresses;
    }
}
