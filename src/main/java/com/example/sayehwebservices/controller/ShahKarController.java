package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.ShahKarService;
import com.example.sayehwebservices.services.dto.ShahKarReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/shahkar")
public class ShahKarController {

    @Autowired
    ShahKarService shahKarService;

    @PostMapping("/primary-end-point")
    ResponseEntity<Object> sendSms(
            @RequestBody ShahKarReq req
    ) throws IOException {
        ResponseEntity<Object> shahkar = null;
        try {
            shahkar = shahKarService.getShahkar(req.getMobile(), req.getNationalCode());
        } catch (Exception exception) {
            shahKarService.giveFailureResponse(exception);
            exception.printStackTrace();
            throw exception;
        }
        return shahkar;
    }
}
