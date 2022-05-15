package com.example.sayehwebservices.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SSNStatResponseDto {
    String message;
    int StatusCode;
    int decile;
    boolean hasReceivedFunds;

    public SSNStatResponseDto(String message, int statusCode, int decile) {
        this.message = message;
        StatusCode = statusCode;
        this.decile = decile;
    }
}
