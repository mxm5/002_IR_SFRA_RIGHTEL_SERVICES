package com.example.sayehwebservices.repository;


import com.example.sayehwebservices.domain.EarningReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EarningReportRepository extends JpaRepository<EarningReport, Long> {
    @Query(nativeQuery = true,value = "select refahdb.get_memberid(:ssn) from dual")
    Long getHashedSsn(@Param("ssn") String ssn);
    List<EarningReport> findByResSsn(Long resSsn);
}
