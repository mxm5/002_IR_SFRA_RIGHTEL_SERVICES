package com.example.sayehwebservices.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccessResponse {
    List<AppAccess> accessList;
    String message;
    Boolean canEnter;

}
