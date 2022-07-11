package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.khanevar;
import com.example.sayehwebservices.repository.KhanevarRepository;
import com.example.sayehwebservices.services.dto.FamilyMembersRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class KhanevarService {

    @Autowired
    KhanevarRepository khanevarRepository;

   public FamilyMembersRes getFamilyMembersByParentNationalCode(String nationalCode) {
       Long hashedSsn = khanevarRepository.getHashedSsn(nationalCode);
       List<khanevar> byResSsn = khanevarRepository.findByResSsn(hashedSsn);
       byResSsn.forEach(khanevar -> {
           if (Objects.equals(khanevar.getResSsn(), khanevar.getSsn())) {
               khanevar.setResSsn(Long.parseLong(nationalCode));
               khanevar.setSsn(Long.parseLong(nationalCode));

           }else {
               khanevar.setResSsn(Long.parseLong(nationalCode));
               khanevar.setSsn(0L);
           }

       });




       return new FamilyMembersRes(byResSsn);
   }

}
