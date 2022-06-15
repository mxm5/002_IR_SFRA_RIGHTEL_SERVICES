package com.example.sayehwebservices;

import com.example.sayehwebservices.repository.SSNSStatRepository;
import com.example.sayehwebservices.services.SSNStatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Map;

@SpringBootTest
class SayehWebservicesApplicationTests {

    @Autowired
    SSNStatService service;

    @Test
    void contextLoads() {
//       service.getShitC("1111111111");
        service.gsd();
    }

}
