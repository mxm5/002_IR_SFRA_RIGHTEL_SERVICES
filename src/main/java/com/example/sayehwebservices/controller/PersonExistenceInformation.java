package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.SSNStatService;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import com.example.sayehwebservices.services.dto.SSNStatResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/individual-existence-status")
@AllArgsConstructor
public class PersonExistenceInformation {


    @Autowired
    SSNStatService ssnStatService;


    @PostMapping("/by-national-code")
    SSNStatResponseDto get(@RequestBody @Valid NationalCodeRequest nationalCodeRequest) {
        return ssnStatService.getForPersonByNationalCode(nationalCodeRequest.getNationalCode());
    }



}
