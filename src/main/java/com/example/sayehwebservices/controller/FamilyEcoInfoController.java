package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.EconomicInfoService;
import com.example.sayehwebservices.services.EconomicInformationInquiryService;
import com.example.sayehwebservices.services.LogsServiece;
import com.example.sayehwebservices.services.dto.EcoInfoResponseDto;
import com.example.sayehwebservices.services.dto.FamilyMembersRes;
import com.example.sayehwebservices.services.dto.GeneralEconomicStatusResponse;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/economic-evidence-informer")
@AllArgsConstructor
public class FamilyEcoInfoController {

// todo: log in database
    private EconomicInfoService ecoInfoService;

    public final LogsServiece logsServiece;

    @Autowired
    public FamilyEcoInfoController(LogsServiece logsServiece) {
        this.logsServiece = logsServiece;
    }


    @PostMapping("/by-national-code")
    EcoInfoResponseDto get(@RequestBody NationalCodeRequest nationalCodeRequest) {
        return ecoInfoService.getByPersonNationalCode(nationalCodeRequest.getNationalCode());
    }

    @Autowired
    EconomicInformationInquiryService inquiryService;

    @PostMapping("/detailed-inquiry")
    GeneralEconomicStatusResponse getEconomicStatuesForPersonByNationalCode(@RequestBody @Valid NationalCodeRequest nationalCodeRequest) throws Exception {
        return inquiryService.getEconomicStatuesForPersonByNationalCode(nationalCodeRequest.getNationalCode());
    }


}