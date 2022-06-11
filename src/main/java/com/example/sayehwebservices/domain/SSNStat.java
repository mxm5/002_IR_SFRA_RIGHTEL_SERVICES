package com.example.sayehwebservices.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "VW_REFAH_SSNSTAT", schema = "SAYEH", catalog = "")
@ToString
public class SSNStat {
    @Id
    @Basic
    @Column(name = "SSN", nullable = true, length = 10)
    private String ssn;
    @Basic
    @Column(name = "SSN_STAT", nullable = true, precision = 0)
    private Integer ssnStat;
    @Basic
    @Column(name = "DECILE", nullable = true, precision = 0)
    private Integer decile;
    @Basic
    @Column(name = "MASHMOOL", nullable = true, precision = 0)
    private Integer mashmool;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SSNStat ssnStat1 = (SSNStat) o;
        return ssnStat == ssnStat1.ssnStat && decile == ssnStat1.decile && Objects.equals(ssn, ssnStat1.ssn) && Objects.equals(mashmool, ssnStat1.mashmool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, ssnStat, decile, mashmool);
    }
}
