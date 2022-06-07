package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.SSNStat;
import com.example.sayehwebservices.repository.SSNSStatRepository;
import com.example.sayehwebservices.services.dto.SSNStatResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SSNStatService {

    @Autowired
    SSNSStatRepository ssnsStatRepository;

    public SSNStatResponseDto getForPersonByNationalCode(String nationalCode) {
        SSNStat statusByNationalCode = ssnsStatRepository.getStatusByNationalCode(
                nationalCode
        );



        if (statusByNationalCode != null) {

            if (statusByNationalCode.getSsnStat() == 1) {
                return new SSNStatResponseDto(
                        "این کد ملی به عنوان سرپرست در سامانه ثبت شده است",
                        1,
                        statusByNationalCode.getDecile(),
                        statusByNationalCode.getMashmool()==1

                );
            } else {
                return new SSNStatResponseDto(
                        "این کد ملی به عنوان فرد غیر سرپرست ثبت شده میباشد",
                        2,
                        statusByNationalCode.getDecile(),
                        statusByNationalCode.getMashmool()==1

                );
            }
        } else {
            return new SSNStatResponseDto(
                    "این کد ملی در سامانه ثبت نشده است",
                    0,
                    -1);
        }


    }

}
