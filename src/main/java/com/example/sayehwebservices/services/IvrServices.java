package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.IvrYaranehStat;
import com.example.sayehwebservices.repository.IvrConventionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IvrServices {

    final IvrConventionStatusRepository ivrConventionStatusRepository;
    final LogsServiece logsServiece;

    @Autowired
    public IvrServices(IvrConventionStatusRepository ivrConventionStatusRepository, LogsServiece logsServiece) {
        this.ivrConventionStatusRepository = ivrConventionStatusRepository;
        this.logsServiece = logsServiece;
    }

   public IvrYaranehStat getByResSSN(String nationalCode) {
       IvrYaranehStat byResSsn = ivrConventionStatusRepository.findByResSsn(nationalCode);

       return byResSsn;
   }

}
