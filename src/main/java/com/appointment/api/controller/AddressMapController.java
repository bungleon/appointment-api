package com.appointment.api.controller;

import com.appointment.api.handler.address.AddressMapHandler;
import com.appointment.api.message.request.appointment.AppointmentListRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/address")
public class AddressMapController {
    private final AddressMapHandler addressMapHandler;

    public AddressMapController(AddressMapHandler addressMapHandler) {
        this.addressMapHandler = addressMapHandler;
    }

    @PostMapping("/fill-all")
    public String fillAll() throws IOException {
        return addressMapHandler.execute("OK");
    }
}
