package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.PublicProfileService;
import com.example.sayehwebservices.services.dto.PublicProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

@RequestMapping("/api/v1/gov-registered-public-profile")
public class GovernmentalPublicProfileRegistrationController {

    @Autowired
    PublicProfileService publicProfileService;


    @PostMapping(value = "/by-national-code-birthday")
    ResponseEntity<Object> getByNCAndBD(@Valid @RequestBody PublicProfileRequest publicProfileRequest) throws Exception {
        return publicProfileService.getByBirthdayAndNationalCode(publicProfileRequest);
    }
}



