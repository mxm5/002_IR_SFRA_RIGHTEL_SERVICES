package com.example.sayehwebservices.repository;

import com.example.sayehwebservices.domain.SayehLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<SayehLogs,String> {

}
