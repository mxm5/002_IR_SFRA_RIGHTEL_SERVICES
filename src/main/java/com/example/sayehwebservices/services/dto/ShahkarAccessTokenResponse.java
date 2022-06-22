package com.example.sayehwebservices.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShahkarAccessTokenResponse {
    public String access_token;
    public String token_type;
    public String refresh_token;
    public Integer expires_in;
    public String scope;
}