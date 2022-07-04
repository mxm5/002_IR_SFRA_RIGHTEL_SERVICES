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

    @Autowired
    public EconomicInformationInquiryService(CardPercentileReportRepository percentileRepo, CarInfoRepository carsRepo, EarningReportRepository earningRepo, RareDeceaseInfoRepository deceaseRepo, SSNSStatRepository ssnsStatRepository) {
        this.percentileRepo = percentileRepo;
        this.carsRepo = carsRepo;
        this.earningRepo = earningRepo;
        this.deceaseRepo = deceaseRepo;
        this.ssnsStatRepository = ssnsStatRepository;
    }


    public GeneralEconomicStatusResponse getEconomicStatuesForPersonByNationalCode(String nationalCode) throws Exception {

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

        cardPercentileReports.forEach(System.out::println);
        List<CarInformation> carInformationList = carsRepo
                .findByResSsn(hashedSsn);
        carInformationList.forEach(System.out::println);

        List<EarningReport> earningReports = earningRepo
                .findByResSsn(hashedSsn);
        earningReports.forEach(System.out::println);
        List<RareDeceasesInfo> rareDeceasesInfos = deceaseRepo
                .findByResSsn(hashedSsn);
        rareDeceasesInfos.forEach(System.out::println);
        return new GeneralEconomicStatusResponse(
                cardPercentileReports,
                carInformationList,
                earningReports,
                rareDeceasesInfos
        );
//        double percentile = Math.random() * 99L;
//        String parentsNationalCode = nationalCode;
//        String PeriodTitle = "شش ماهه اول 1400";
//        String sonSsn = "3687895123";
//        String sonsFirstName = PersianFaker.getName();
//        String allLastName = PersianFaker.getFamily();
//        Long sonsPercentile = 33L;
//        Long sonsRangeStart = 70_000_000L;
//        Long sonsRangeEnd = 800_000_000L;
//        String daughterSsn = "3312578941";
//        String daughterFirstname = PersianFaker.getName();
//        String daughterLastName = PersianFaker.getFamily();
//        Long daughterPercentile = 65L;
//        Long daughterRangeStart = 40_000_000L;
//        Long daughterRangeEnd = 60_000_000L;
//        String wifeFirstName = PersianFaker.getName();
//        String daughtercarType = "پژو";
//        String daughterCategory = "پارس";
//        String daughterIdn = "33ج157ایران11";
//        Short daughterYear = (short) 1365;
//        String sonsCategory = "405";
//        String wifeSsn = "557896314258";
//        String taminEjtemaInsuranse = "تامین جتماعی";
//        return new GeneralEconomicStatusResponse(
//                List.of(
//                        new CardPercentileReport(
//                                parentsNationalCode,
//                                sonSsn,
//                                sonsFirstName,
//                                allLastName,
//                                sonsPercentile,
//                                sonsRangeStart,
//                                sonsRangeEnd,
//                                PeriodTitle
//                        ),
//                        new CardPercentileReport(
//                                parentsNationalCode,
//                                wifeSsn,
//                                wifeFirstName,
//                                allLastName,
//                                daughterPercentile,
//                                daughterRangeStart,
//                                daughterRangeEnd,
//                                PeriodTitle
//                        ),
//                        new CardPercentileReport(
//                                parentsNationalCode,
//                                daughterSsn,
//                                daughterFirstname,
//                                allLastName,
//                                daughterPercentile,
//                                daughterRangeStart,
//                                daughterRangeEnd,
//                                PeriodTitle
//                        )
//                ),
//                List.of(
//                        new CarInformation(
//                                parentsNationalCode,
//                                daughterSsn,
//                                daughterFirstname,
//                                allLastName,
//                                daughtercarType,
//                                daughterCategory,
//                                daughterIdn,
//                                daughterYear
//                        ),
//                        new CarInformation(
//                                parentsNationalCode,
//                                sonSsn,
//                                sonsFirstName,
//                                allLastName,
//                                daughtercarType,
//                                sonsCategory,
//                                daughterIdn,
//                                daughterYear
//                        ),
//                        new CarInformation
//                                (
//                                        parentsNationalCode,
//                                        wifeSsn,
//                                        wifeFirstName,
//                                        allLastName,
//                                        daughtercarType,
//                                        sonsCategory,
//                                        daughterIdn,
//                                        daughterYear
//                                )
//                ),
//                List.of(
//                        new EarningReport(
//                                parentsNationalCode,
//                                sonSsn,
//                                sonsFirstName,
//                                allLastName,
//                                sonsRangeStart,
//                                sonsRangeEnd,
//                                "کارگر ساختمانی",
//                                taminEjtemaInsuranse
//                        ),
//                        new EarningReport(
//                                parentsNationalCode, daughterSsn,
//                                daughterFirstname,
//                                allLastName,
//                                sonsRangeStart,
//                                sonsRangeEnd,
//                                "معلم",
//                                taminEjtemaInsuranse
//                        ),
//                        new EarningReport(
//                                parentsNationalCode,
//                                wifeSsn,
//                                wifeFirstName,
//                                allLastName,
//                                sonsRangeStart,
//                                sonsRangeEnd,
//                                "آرایشگر",
//                                taminEjtemaInsuranse
//                        ),
//                        new EarningReport(
//                                parentsNationalCode,
//                                wifeSsn,
//                                wifeFirstName,
//                                allLastName,
//                                sonsRangeStart,
//                                sonsRangeEnd,
//                                "کارمند",
//                                taminEjtemaInsuranse
//                        )
//                ),
//                List.of(
//                        new RareDeceasesInfo(
//                                parentsNationalCode,
//                                wifeSsn,
//                                wifeFirstName,
//                                allLastName,
//                                false,
//                                "تالاسمی",
//                                "بهزیستی"
//                        )
//
//                )
//        );
    }
}
