package com.example.sayehwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VW_REFAH_KHANEVAR", schema = "SAYEH", catalog = "")
public class khanevar {


    @Basic
    @Column(name = "RES_SSN", nullable = true, precision = 0)
    private Long resSsn;

    @Id
    @Basic
    @Column(name = "SSN", nullable = false, precision = 0)
    private Long ssn;
    @Basic
    @Column(name = "FIRSTNAME", nullable = true, length = 100)
    private String firstname;
    @Basic
    @Column(name = "LASTNAME", nullable = true, length = 100)
    private String lastname;

    @Basic
    @Column(name = "FATHERNAME", nullable = true, length = 100)
    private String fathername;
    @Basic
    @Column(name = "SHAMSIBIRTHDATE", nullable = true, length = 10)
    private String shamsibirthdate;
    @Basic
    @Column(name = "LOC", nullable = true, length = 0)
    private String loc;
    @Basic
    @Column(name = "DECILE", nullable = true, precision = 0)
    private Byte decile;



}
