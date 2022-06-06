package com.example.sayehwebservices.domain;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "VW_CV_REGINFO", schema = "SAYEH", catalog = "")
public class RegisteredPublicProfile {
    @Id
    @Basic
    @Column(name = "NATIONALCODE", nullable = false, precision = 0)
    private Long nationalcode;
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
    @Column(name = "BIRTHDATE", nullable = true, length = 10)
    private String birthdate;
    @Basic
    @Column(name = "GENDERID", nullable = true, precision = 0)
    private Boolean genderid;

}
