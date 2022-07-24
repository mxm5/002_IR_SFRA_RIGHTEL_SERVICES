package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.Utils.TimeZoneTester;
import com.example.sayehwebservices.services.ShahKarService;
import com.example.sayehwebservices.services.dto.ShahKarReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/api/v1/shahkar")
public class ShahKarController {

    @Autowired
    ShahKarService shahKarService;

    @PostMapping("/primary-end-point")
    ResponseEntity<Object> sendSms(
            @Valid
            @RequestBody ShahKarReq req
    ) throws IOException {
        ResponseEntity<Object> shahkar = null;

        String s = TimeZoneTester.printTimeZone();
        log.info(s);

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
