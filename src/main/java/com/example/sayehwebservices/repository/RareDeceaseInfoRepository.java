package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.RareDeceasesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RareDeceaseInfoRepository extends JpaRepository<RareDeceasesInfo, Long> {
    @Query(nativeQuery = true,value = "select refahdb.get_memberid(:ssn) from dual")
    Long getHashedSsn(@Param("ssn") String ssn);
    List<RareDeceasesInfo> findByResSsn(Long resSsn);
}
