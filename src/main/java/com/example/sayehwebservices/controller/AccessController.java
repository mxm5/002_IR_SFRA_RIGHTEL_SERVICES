package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.AccessService;
import com.example.sayehwebservices.services.LogsServiece;
import com.example.sayehwebservices.services.dto.AccessResponse;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccessController {
    @Autowired
    AccessService accessService;

    @Autowired
    LogsServiece logsServiece;

    // todo : log it
    @PostMapping("/get-system-access")
    public AccessResponse getAccessFor(@RequestBody NationalCodeRequest nationalCodeRequest) throws Exception {
        String nationalCode = nationalCodeRequest.getNationalCode();

        return accessService.getAccessInfo(nationalCode);
    }

}
