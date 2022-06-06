package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.RegisteredPublicProfile;
import com.example.sayehwebservices.domain.Transaction;
import com.github.mfathi91.time.PersianDate;
import com.github.mfathi91.time.PersianMonth;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.LocalTime;

//import static org.graalvm.compiler.asm.sparc.SPARCAssembler.Fcn.Page;


//@RunWith(SpringRunner.class) // nothing
////@DataJpaTest // also does nothing
//@RunWith(SpringRunner.class) // does nothing man
@SpringBootTest // allows you to auto wire things
@Slf4j
class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;



    @Autowired PublicProfileRepository publicProfileRepository;

    @Test
    void testForQueryingCVReg() {

        RegisteredPublicProfile byNationalcodeAndBirthdate = publicProfileRepository.findByNationalcodeAndBirthdate(
                1600037461L,"1959-01-29"
        );
        System.out.println(byNationalcodeAndBirthdate);
    }



    @Test
    void findTransactionsPagedByTwoDateRanges() {

        System.out.println(transactionRepository);

        LocalTime t20_20 = LocalTime.of(20, 20);
        PersianDate farvardin401_1 = PersianDate.of(1401, PersianMonth.FARVARDIN, 1);
        PersianDate farvardin401_20 = PersianDate.of(1401, PersianMonth.FARVARDIN, 20);

//        PersianDateTime persianDate = PersianDateTime.of(farvardin401_1, t20_20);
//        LocalDateTime localDateTime = persianDate.toGregorian();
        Pageable first20 = PageRequest.of(1, 20);
        LocalDateTime start = LocalDateTime.of(farvardin401_1.toGregorian(), t20_20);
        LocalDateTime end = LocalDateTime.of(farvardin401_20.toGregorian(), t20_20);
        //
        //
//        log.info("here is the first 20 ");
//        Page<Transaction> transactionsPagedByTwoDateRanges = transactionRepository
//                .findTransactionsPagedByTwoDateRanges(
//                        start, end, first20
//                );

//        transactionsPagedByTwoDateRanges.getContent().forEach(System.out::println);
//        log.info("last 20");
        Pageable last20 = PageRequest.of(2, 20);
//        Page<Transaction> transactionsPagedByTwoDateRanges1 = transactionRepository.findTransactionsPagedByTwoDateRanges(start, end, last20);
//        transactionsPagedByTwoDateRanges1.getContent().forEach(System.out::println);
        log.info("next for a national code");
        String f01Ncode = "6469322735";
//        Page<Transaction> byF01NcodeAndF05LocaldateBetween = transactionRepository
//                .findByF01NcodeAndF05TxLocaldatIsBetween(
//                        f01Ncode, start, end, first20);
//        log.info("res for byF01NcodeAndF05LocaldateBetween is");
//
//        byF01NcodeAndF05LocaldateBetween.forEach(System.out::println);
//
//        log.info("now reverse man");
//
//        Page<Transaction> byF05TxLocaldatBetweenAndF01NcodeIs = transactionRepository.findByF05TxLocaldatBetweenAndF01NcodeIs(
//                 start, end, f01Ncode, first20
//        );
//        System.out.println(byF05TxLocaldatBetweenAndF01NcodeIs.getContent().size());
//        byF05TxLocaldatBetweenAndF01NcodeIs.forEach(System.out::println);
//        System.out.println("byF05TxLocaldatBetweenAndF01NcodeIs self"+byF05TxLocaldatBetweenAndF01NcodeIs);
//        System.out.println("byF05TxLocaldatBetweenAndF01NcodeIs content"+byF05TxLocaldatBetweenAndF01NcodeIs.getContent());
//        System.out.println("========================================");
//        Page<Transaction> transactionsPagedByTwoDateRangesAndNationalCode = transactionRepository.findTransactionsPagedByTwoDateRangesAndNationalCode(
//                start, end, f01Ncode, first20
//        );
//        log.info("with query");
//        transactionsPagedByTwoDateRangesAndNationalCode.getContent().forEach(System.out::println);
//        transactionsPagedByTwoDateRangesAndNationalCode.forEach(System.out::println);


        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");

        Pageable first2 = PageRequest.of(1, 2);
        Pageable third2 = PageRequest.of(3, 2);
        Pageable second2 = PageRequest.of(2, 2);
        Pageable first200 = PageRequest.of(1, 200);
        Pageable first5 = PageRequest.of(1, 5);

        System.out.println(start);
        System.out.println(end);
        Page<Transaction> aTrue = transactionRepository.findByF05TxLocaldatBetweenAndF01NcodeIs(start, end,f01Ncode,PageRequest.of(0,10)); // shown
//        Page<Transaction> aTrue = transactionRepository.findByF05TxLocaldatIsBetweenAndF01Ncode(start, end,f01Ncode,second2); // shown
//        Page<Transaction> aTrue = transactionRepository.findByF05TxLocaldatIsBetweenAndF01Ncode(start, end,f01Ncode,third2); //not shown
//        Page<Transaction> aTrue = transactionRepository.findByF05TxLocaldatIsBetweenAndF01Ncode(start, end,f01Ncode,first20); not shown
//        Page<Transaction> aTrue = transactionRepository.findByF05TxLocaldatIsBetweenAndF01Ncode(start, end,f01Ncode,first200); not shown
//        Page<Transaction> aTrue = transactionRepository.getTrueB(start, end,f01Ncode,first2); shown
        System.out.println("value");
        aTrue.forEach(System.out::println);
        System.out.println("content");
//        aTrue.getContent().forEach(System.out::println);
        System.out.println("size");
        System.out.println(aTrue.getSize());

    }

}