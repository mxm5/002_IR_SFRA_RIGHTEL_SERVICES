package com.example.sayehwebservices.services;

import com.example.sayehwebservices.repository.AccessRepo;
import com.example.sayehwebservices.services.dto.AccessResponse;
import com.example.sayehwebservices.services.dto.AppAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccessService {
    @Autowired
    AccessRepo accessRepo;

    @Autowired
    SSNStatService ssnStatService;

    public AccessResponse getAccessInfo(String nationalCode) throws Exception {



       return ssnStatService.getAccessFromOracleFunction(nationalCode);

    }
}
