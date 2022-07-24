package com.example.sayehwebservices.controller.rightels;

import com.example.sayehwebservices.Config.exception.DecileInfoCodedException;
import com.example.sayehwebservices.services.DecileInformationService;
import com.example.sayehwebservices.services.dto.DecileInfoResponseDto;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import com.example.sayehwebservices.services.dto.RemainingCreditRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/decile-info")
@AllArgsConstructor
@Slf4j
public class DecileInformationController {


    @Autowired
    DecileInformationService decileInformationService;

    @PostMapping("/by-national-code")
    DecileInfoResponseDto getRemainingCredit(@RequestBody @Valid NationalCodeRequest request) throws DecileInfoCodedException {
        return decileInformationService.getForNationalCode(request.getNationalCode());
    }
}
