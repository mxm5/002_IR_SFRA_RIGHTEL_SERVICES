package com.example.sayehwebservices.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "VW_CARD_PERCENTILE", schema = "SAYEH", catalog = "")
public class CardPercentileReport {
    @Id
    @Basic
    @Column(name = "GUID", nullable = true)
    private String  guid;
    @Basic
    @Column(name = "RES_SSN", nullable = true, precision = 0)
    private Long resSsn;
    @Basic
    @Column(name = "SSN", nullable = true, length = 0)
    private String ssn;
    @Basic
    @Column(name = "FIRSTNAME", nullable = true, length = 100)
    private String firstname;
    @Basic
    @Column(name = "LASTNAME", nullable = true, length = 0)
    private String lastname;
    @Basic
    @Column(name = "PERCENTILE", nullable = true, precision = 0)
    private Long percentile;
    @Basic
    @Column(name = "FROMAMOUNT", nullable = true, precision = 0)
    private Long fromamount;
    @Basic
    @Column(name = "TOAMOUNT", nullable = true, precision = 0)
    private Long toamount;
    @Basic
    @Column(name = "PERIODTITLE", nullable = true, length = 100)
    private String periodtitle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardPercentileReport that = (CardPercentileReport) o;
        return Objects.equals(resSsn, that.resSsn) && Objects.equals(ssn, that.ssn) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(percentile, that.percentile) && Objects.equals(fromamount, that.fromamount) && Objects.equals(toamount, that.toamount) && Objects.equals(periodtitle, that.periodtitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resSsn, ssn, firstname, lastname, percentile, fromamount, toamount, periodtitle);
    }
}
