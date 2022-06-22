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
@Table(name = "VW_EARNING", schema = "SAYEH", catalog = "")
public class EarningReport {
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
    @Column(name = "FIXEDEARNINGAMOUNT", nullable = true, precision = 0)
    private Long fixedearningamount;
    @Basic
    @Column(name = "BANKPROFITAMOUNT", nullable = true, precision = 0)
    private Long bankprofitamount;
    @Basic
    @Column(name = "JOBTITLE", nullable = true, length = 100)
    private String jobtitle;
    @Basic
    @Column(name = "INCOMEREPORTSOURCE", nullable = true, length = 100)
    private String incomereportsource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EarningReport that = (EarningReport) o;
        return Objects.equals(resSsn, that.resSsn) && Objects.equals(ssn, that.ssn) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(fixedearningamount, that.fixedearningamount) && Objects.equals(bankprofitamount, that.bankprofitamount) && Objects.equals(jobtitle, that.jobtitle) && Objects.equals(incomereportsource, that.incomereportsource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resSsn, ssn, firstname, lastname, fixedearningamount, bankprofitamount, jobtitle, incomereportsource);
    }
}
