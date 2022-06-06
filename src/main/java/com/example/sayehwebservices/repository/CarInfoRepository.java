package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.CarInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarInfoRepository extends JpaRepository<CarInformation, Long> {
    @Query(nativeQuery = true,value = "select refahdb.get_memberid(:ssn) from dual")
    Long getHashedSsn(@Param("ssn") String ssn);
    List<CarInformation> findByResSsn(/*@Param("resSsn")*/ Long resSsn);
}
