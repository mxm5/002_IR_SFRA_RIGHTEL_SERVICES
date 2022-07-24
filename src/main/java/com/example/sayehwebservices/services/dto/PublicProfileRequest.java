package com.example.sayehwebservices.services.dto;

import com.example.sayehwebservices.validation.NationalCodeValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicProfileRequest {
    @NationalCodeValid(message = "insert valid national code")
    public String NationalCode;
    public String BirthDate;
}
