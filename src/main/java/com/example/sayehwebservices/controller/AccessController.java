package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.AccessService;
import com.example.sayehwebservices.services.dto.AccessResponse;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccessController {
    @Autowired
    AccessService accessService;

    @PostMapping("/get-system-access")
    public AccessResponse getAccessFor(NationalCodeRequest nationalCodeRequest) {
        String nationalCode = nationalCodeRequest.getNationalCode();
        return accessService.getAccessInfo(nationalCode);
    }

}