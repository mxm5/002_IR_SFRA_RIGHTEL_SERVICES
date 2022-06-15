package com.example.sayehwebservices;

import com.example.sayehwebservices.domain.Merchant;
import com.example.sayehwebservices.domain.Region;
import com.example.sayehwebservices.domain.khanevar;
import com.example.sayehwebservices.repository.KhanevarRepository;
import com.example.sayehwebservices.repository.MerchantRepository;
import com.example.sayehwebservices.repository.RegionRepository;
import com.example.sayehwebservices.repository.regionProjections.RegionWithNameAndCode;
import com.example.sayehwebservices.services.dto.ProvinceResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class SayehWebservicesApplication /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(SayehWebservicesApplication.class, args);
    }

//    @Autowired
//    RegionRepository regionRepository;
//
//    //
//    @Autowired
//    MerchantRepository merchantRepository;
////
//    @Autowired
//    KhanevarRepository khanevarRepository;
//
//    @Autowired
//    KhanevarService khanevarService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        //  2529576092   has 6 members
//        AtomicInteger i = new AtomicInteger(0);
//        Pageable page = PageRequest.of(0, 10);
//        Collection<RegionWithNameAndCode>
//                allOfProvincesWithCodeAndName =
//                regionRepository.
//                        getAllOfProvincesWithCodeAndName();
//        for (RegionWithNameAndCode region : allOfProvincesWithCodeAndName) {
//            System.out.println(region);
//            System.out.println(region.getProvinceName());
//            System.out.println(region.getProvinceName());
//        }
//
//        List<ProvinceResponseDto> allProvince =
//                regionRepository.getAllProvince();
//        for (ProvinceResponseDto region : allProvince) {
//            System.out.println(region);
//            System.out.println(region.getProvinceName());
//            System.out.println(region.getProvinceName());
//        }
//
//        List<Object[]> allProvinces = regionRepository.getAllProvinces();
//        for (Object[] o : allProvinces) {
//            System.out.println("----");
//            String x = (String) o[0];
//            String y = (String) o[1];
//            byte[] bytes = y.getBytes(StandardCharsets.UTF_16BE);
//            String utf8EncodedString = new String(bytes, StandardCharsets.UTF_16BE);
//            System.out.println(utf8EncodedString);
//            bytes = y.getBytes(StandardCharsets.UTF_16LE);
//            utf8EncodedString = new String(bytes, StandardCharsets.UTF_16LE);
//            System.out.println(utf8EncodedString);
//            bytes = y.getBytes(StandardCharsets.UTF_16);
//            utf8EncodedString = new String(bytes, StandardCharsets.UTF_16);
//            System.out.println(utf8EncodedString);
//            System.out.println(y);
//            Object o1 = o[0];
//            System.out.println(o1);
//            Object o2 = o[1];
//            System.out.println(o2);
//        }
//        Page<Region> all = regionRepository.findAll(page);
//        all.forEach(System.out::println);
////        Page<khanevar> all1 = khanevarRepository.findAll(page);
////        all1.forEach(System.out::println);
//        Page<Merchant> all2 = merchantRepository.findAll(page);
//        all2.forEach(System.out::println);
//    }



}
