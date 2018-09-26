package com.appointment.api.controller;

import com.appointment.api.handler.town.TownListHandler;
import com.appointment.api.message.request.town.TownListRequest;
import com.appointment.api.message.response.town.TownListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/town")
public class TownController {
    private final TownListHandler townListHandler;

    public TownController(TownListHandler townListHandler) {
        this.townListHandler = townListHandler;
    }

    @PostMapping("/list")
    public TownListResponse getTownList(@RequestBody TownListRequest request) {
        return townListHandler.execute(request);
    }
}
