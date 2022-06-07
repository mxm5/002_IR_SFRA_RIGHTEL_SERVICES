package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.khanevar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface KhanevarRepository extends JpaRepository<khanevar, String> {
    @Query(value = "select * from VW_REFAH_KHANEVAR where RES_SSN =:resSsn",nativeQuery = true)
    List<khanevar> findByResSsn(Long resSsn);

    // TODO: MAKE THIS QUERY FASTER FOR EXECUTION
    @Query(value = "select * from TB_KHANEVAR where RES_SSN =:resSsn",nativeQuery = true)
    List<khanevar> findByResSsnNativeQuery(@Param("resSsn") String resSsn);

    @Query(nativeQuery = true,value = "select refahdb.get_memberid(:ssn) from dual")
    Long getHashedSsn(@Param("ssn") String ssn);
}
