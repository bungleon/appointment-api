package com.appointment.api.controller;

import com.appointment.api.handler.address.AddressListHandler;
import com.appointment.api.message.request.address.AddressListRequest;
import com.appointment.api.message.response.address.AddressListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressListHandler addressListHandler;

    public AddressController(AddressListHandler addressListHandler) {
        this.addressListHandler = addressListHandler;
    }

    @PostMapping("/address-list")
    public AddressListResponse getAddressList(@RequestBody AddressListRequest request) {
        return addressListHandler.execute(request);
    }
}
