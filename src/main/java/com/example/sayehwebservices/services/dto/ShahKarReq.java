package com.example.sayehwebservices.services.dto;

import com.example.sayehwebservices.validation.NationalCodeValid;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShahKarReq {
        String mobile;
        @NationalCodeValid(message = "national code is not valid")
        String nationalCode;
}
