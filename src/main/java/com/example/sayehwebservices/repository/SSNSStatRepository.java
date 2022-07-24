package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.SSNStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
@Repository
public interface SSNSStatRepository extends JpaRepository<SSNStat, String> {

    @Query(value = "select * from VW_REFAH_SSNSTAT where SSN = :nationalCode and ROWNUM = 1", nativeQuery = true)
    SSNStat getStatusByNationalCode(@Param("nationalCode") String nationalCode);
    @Query(value = "select refahdb.PKG_VALIDATION.Fn_Check_SSN(:nationalCode) from dual", nativeQuery = true)
    Integer checkNationalCodeValidity(@Param("nationalCode") String nationalCode);



}
