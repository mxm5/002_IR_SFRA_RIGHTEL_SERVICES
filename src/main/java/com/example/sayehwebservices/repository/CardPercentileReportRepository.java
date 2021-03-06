package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.CardPercentileReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardPercentileReportRepository extends JpaRepository<CardPercentileReport,String > {

    @Query(nativeQuery = true,value = "select refahdb.get_memberid(:ssn) from dual")
    Long getHashedSsn(@Param("ssn") String ssn);


//    @Query(nativeQuery = true,value = "select * from SAYEH.VW_CARD_PERCENTILE v where RES_SSN =:resSsn order by v.PERCENTILE asc ")
    List<CardPercentileReport> findByResSsnOrderByPercentile(@Param("resSsn") Long resSsn);
}
