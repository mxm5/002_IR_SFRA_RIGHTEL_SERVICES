package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.IvrYaranehStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IvrConventionStatusRepository extends JpaRepository<IvrYaranehStat, String> {
    IvrYaranehStat findByResSsn(String resSsn);
}
