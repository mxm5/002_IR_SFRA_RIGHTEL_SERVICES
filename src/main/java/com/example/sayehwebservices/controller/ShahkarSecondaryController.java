package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.RequestSender;
import com.example.sayehwebservices.services.dto.CityResponseDto;
import com.example.sayehwebservices.services.dto.ProvinceCodeRequestDto;
import com.example.sayehwebservices.services.dto.ShahKarReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ict-only-services")
public class ShahkarSecondaryController {


    @Autowired
    RequestSender requestSender;

    @PostMapping("/shahkar-secondary-end-point")
    ResponseEntity<Object> getShahkarResponse(
            @RequestBody ShahKarReq shahKarReq
    ) {

        try {
            requestSender.getTokenForShahkar();
        } catch (IOException e) {
            return requestSender.giveFailureResponse(e);
        }
        return null;
    }

}
