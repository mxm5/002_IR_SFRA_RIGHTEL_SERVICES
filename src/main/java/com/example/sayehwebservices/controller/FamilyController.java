package com.example.sayehwebservices.controller;

import com.example.sayehwebservices.services.KhanevarService;
import com.example.sayehwebservices.services.dto.FamilyMembersRes;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/api/v1/family")
@AllArgsConstructor
public class FamilyController {

    final
    KhanevarService khanevarService;

    @PostMapping("/get-family-members-by-household-parent-national-code")
    FamilyMembersRes getFamilyMembersByHouseHoldParentNationalCode(@RequestBody NationalCodeRequest nationalCodeRequest) {
        return khanevarService.getFamilyMembersByParentNationalCode(
                nationalCodeRequest.getNationalCode()
        );
    }

}


