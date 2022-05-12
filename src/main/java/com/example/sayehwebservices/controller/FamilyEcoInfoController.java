package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.EconomicInfoService;
import com.example.sayehwebservices.services.dto.EcoInfoResponseDto;
import com.example.sayehwebservices.services.dto.FamilyMembersRes;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/economic-evidence-informer")
@AllArgsConstructor
public class FamilyEcoInfoController {


    private EconomicInfoService ecoInfoService;

    @PostMapping("/by-national-code")
    EcoInfoResponseDto get(@RequestBody NationalCodeRequest nationalCodeRequest) {
        return ecoInfoService.getByPersonNationalCode(nationalCodeRequest.getNationalCode());
    }
}
