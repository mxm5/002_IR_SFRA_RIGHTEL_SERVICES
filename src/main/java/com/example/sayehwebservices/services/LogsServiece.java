package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.SayehLogs;
import com.example.sayehwebservices.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogsServiece {
    @Autowired
    LogRepository logRepository;
    public Boolean logForNationalCode(String nationalCode) {
        SayehLogs currentLog=new SayehLogs();
        currentLog.setNationalCode(nationalCode);
        currentLog.setLocalDateTime(LocalDateTime.now());
        SayehLogs save = logRepository.save(currentLog);
        if (save.getId()!=null) {
            return true;
        }
        return false;
    }

    public Boolean logForNationalCodeWithDescription(String nationalCode,String serviceName) {
        SayehLogs currentLog=new SayehLogs();
        currentLog.setNationalCode(nationalCode);
        currentLog.setLocalDateTime(LocalDateTime.now());
        currentLog.setServiceName(serviceName);
        SayehLogs save = logRepository.save(currentLog);
        if (save.getId()!=null) {
            return true;
        }
        return false;
    }

    public Boolean logForNationalCodeWithDescriptionAndSuccess(String nationalCode,String serviceName,Boolean success) {
        SayehLogs currentLog=new SayehLogs();
        currentLog.setNationalCode(nationalCode);
        currentLog.setLocalDateTime(LocalDateTime.now());
        currentLog.setServiceName(serviceName);
        currentLog.setSuccessfulResult(success);
        SayehLogs save = logRepository.save(currentLog);
        if (save.getId()!=null) {
            return true;
        }
        return false;
    }
}
