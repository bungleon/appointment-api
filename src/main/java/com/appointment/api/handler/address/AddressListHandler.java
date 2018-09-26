package com.appointment.api.handler.address;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.AddressDto;
import com.appointment.api.message.request.address.AddressListRequest;
import com.appointment.api.message.response.address.AddressListResponse;
import com.appointment.api.service.address.AddressService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressListHandler implements Handler<AddressListRequest, AddressListResponse> {
    private final AddressService addressService;

    public AddressListHandler(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public AddressListResponse execute(AddressListRequest request) {
        List<AddressDto> addressDtos = addressService.getByDistrictId(request.getDistrictId())
                .stream()
                .map(AddressDto::new)
                .collect(Collectors.toList());

        return AddressListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .addresses(addressDtos)
                .build();
    }
}
