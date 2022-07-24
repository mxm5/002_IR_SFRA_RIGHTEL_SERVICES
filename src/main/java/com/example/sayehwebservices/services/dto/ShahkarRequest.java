package com.example.sayehwebservices.services.dto;

import com.example.sayehwebservices.validation.NationalCodeValid;
import lombok.*;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShahkarRequest {
    private String mobile;
    @NationalCodeValid(message = "national code is not valid")
    private String nationalCode;
}
