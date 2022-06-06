package com.example.sayehwebservices.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "VW_CARD_PERCENTILE", schema = "SAYEH", catalog = "")
public class VwCardPercentile {
    @Id
    @Basic
    @Column(name = "RES_SSN", nullable = true, precision = 0)
    private BigInteger resSsn;
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
    private BigInteger percentile;
    @Basic
    @Column(name = "FROMAMOUNT", nullable = true, precision = 0)
    private BigInteger fromamount;
    @Basic
    @Column(name = "TOAMOUNT", nullable = true, precision = 0)
    private BigInteger toamount;
    @Basic
    @Column(name = "PERIODTITLE", nullable = true, length = 100)
    private String periodtitle;

    public BigInteger getResSsn() {
        return resSsn;
    }

    public void setResSsn(BigInteger resSsn) {
        this.resSsn = resSsn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public BigInteger getPercentile() {
        return percentile;
    }

    public void setPercentile(BigInteger percentile) {
        this.percentile = percentile;
    }

    public BigInteger getFromamount() {
        return fromamount;
    }

    public void setFromamount(BigInteger fromamount) {
        this.fromamount = fromamount;
    }

    public BigInteger getToamount() {
        return toamount;
    }

    public void setToamount(BigInteger toamount) {
        this.toamount = toamount;
    }

    public String getPeriodtitle() {
        return periodtitle;
    }

    public void setPeriodtitle(String periodtitle) {
        this.periodtitle = periodtitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VwCardPercentile that = (VwCardPercentile) o;

        if (resSsn != null ? !resSsn.equals(that.resSsn) : that.resSsn != null) return false;
        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (percentile != null ? !percentile.equals(that.percentile) : that.percentile != null) return false;
        if (fromamount != null ? !fromamount.equals(that.fromamount) : that.fromamount != null) return false;
        if (toamount != null ? !toamount.equals(that.toamount) : that.toamount != null) return false;
        if (periodtitle != null ? !periodtitle.equals(that.periodtitle) : that.periodtitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resSsn != null ? resSsn.hashCode() : 0;
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (percentile != null ? percentile.hashCode() : 0);
        result = 31 * result + (fromamount != null ? fromamount.hashCode() : 0);
        result = 31 * result + (toamount != null ? toamount.hashCode() : 0);
        result = 31 * result + (periodtitle != null ? periodtitle.hashCode() : 0);
        return result;
    }
}
