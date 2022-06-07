package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.khanevar;
import com.example.sayehwebservices.repository.KhanevarRepository;
import com.example.sayehwebservices.services.dto.FamilyMembersRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KhanevarService {

    @Autowired
    KhanevarRepository khanevarRepository;

   public FamilyMembersRes getFamilyMembersByParentNationalCode(String nationalCode) {
       Long hashedSsn = khanevarRepository.getHashedSsn(nationalCode);
       List<khanevar> byResSsn = khanevarRepository.findByResSsn(hashedSsn);
       byResSsn.forEach(khanevar -> {
           khanevar.setResSsn(Long.parseLong(nationalCode));
           khanevar.setSsn(0L);
       });

       return new FamilyMembersRes(byResSsn);
   }

}
