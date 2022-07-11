package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.*;
import com.example.sayehwebservices.repository.*;
import com.example.sayehwebservices.services.dto.GeneralEconomicStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EconomicInformationInquiryService {

    final CardPercentileReportRepository percentileRepo;
    final CarInfoRepository carsRepo;
    final EarningReportRepository earningRepo;
    final RareDeceaseInfoRepository deceaseRepo;
    final SSNSStatRepository ssnsStatRepository;
final LogsServiece logsServiece;
    @Autowired
    public EconomicInformationInquiryService(CardPercentileReportRepository percentileRepo, CarInfoRepository carsRepo, EarningReportRepository earningRepo, RareDeceaseInfoRepository deceaseRepo, SSNSStatRepository ssnsStatRepository, LogsServiece logsServiece) {
        this.percentileRepo = percentileRepo;
        this.carsRepo = carsRepo;
        this.earningRepo = earningRepo;
        this.deceaseRepo = deceaseRepo;
        this.ssnsStatRepository = ssnsStatRepository;
        this.logsServiece = logsServiece;
    }


    public GeneralEconomicStatusResponse getEconomicStatuesForPersonByNationalCode(String nationalCode) throws Exception {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();
            long hashedSsn = earningRepo.getHashedSsn(nationalCode);
            if (username.equals("2b3938393132363230")) {
                SSNStat statusByNationalCode = ssnsStatRepository.getStatusByNationalCode(
                        nationalCode
                );
                if (statusByNationalCode.getDecile() > 5) {
                    throw new Exception("اطلاعات برای دهک های بیشتر از 5 نمایش داده نمیشود");
                }
            }

            List<CardPercentileReport> cardPercentileReports = percentileRepo
                    .findByResSsnOrderByPercentile(hashedSsn);

//        cardPercentileReports.forEach(System.out::println);
            List<CarInformation> carInformationList = carsRepo
                    .findByResSsn(hashedSsn);
//        carInformationList.forEach(System.out::println);

            List<EarningReport> earningReports = earningRepo
                    .findByResSsn(hashedSsn);
//        earningReports.forEach(System.out::println);
            List<RareDeceasesInfo> rareDeceasesInfos = deceaseRepo
                    .findByResSsn(hashedSsn);
//        rareDeceasesInfos.forEach(System.out::println);


            GeneralEconomicStatusResponse generalEconomicStatusResponse = new GeneralEconomicStatusResponse(
                    cardPercentileReports,
                    carInformationList,
                    earningReports,
                    rareDeceasesInfos
            );
            logsServiece.logForNationalCodeWithDescriptionAndSuccess(nationalCode, "detailed-inquiry", true);
            return generalEconomicStatusResponse;
        } catch (Exception exception) {
            exception.printStackTrace();
            logsServiece.logForNationalCodeWithDescriptionAndSuccess(nationalCode, "detailed-inquiry-err cause msg:[[" + exception.getMessage() + "]]", false);
            throw exception;
        }

    }
}
