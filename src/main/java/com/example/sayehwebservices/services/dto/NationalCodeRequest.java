package com.example.sayehwebservices.services.dto;

import com.example.sayehwebservices.validation.NationalCodeValid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NationalCodeRequest {
    @NationalCodeValid
    String nationalCode;
}
