package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.RegisteredPublicProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PublicProfileRepository extends JpaRepository<RegisteredPublicProfile, String> {
    @Query(nativeQuery = true,value = "select refahdb.get_memberid(:ssn) from dual")
    Long getHashedSsn(@Param("ssn") String ssn);
    RegisteredPublicProfile findByNationalcodeAndBirthdate(Long nationalcode, String birthdate);
}
