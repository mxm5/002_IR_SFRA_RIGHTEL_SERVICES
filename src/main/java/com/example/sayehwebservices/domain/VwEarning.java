package com.example.sayehwebservices.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Arrays;

@Entity
@Table(name = "VW_EARNING", schema = "SAYEH", catalog = "")
public class VwEarning {
    @Id
    @Basic
    @Column(name = "GUID", nullable = true)
    private Byte[] guid;
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
    @Column(name = "FIXEDEARNINGAMOUNT", nullable = true, precision = 0)
    private BigInteger fixedearningamount;
    @Basic
    @Column(name = "BANKPROFITAMOUNT", nullable = true, precision = 0)
    private BigInteger bankprofitamount;
    @Basic
    @Column(name = "JOBTITLE", nullable = true, length = 100)
    private String jobtitle;
    @Basic
    @Column(name = "INCOMEREPORTSOURCE", nullable = true, length = 100)
    private String incomereportsource;


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

    public BigInteger getFixedearningamount() {
        return fixedearningamount;
    }

    public void setFixedearningamount(BigInteger fixedearningamount) {
        this.fixedearningamount = fixedearningamount;
    }

    public BigInteger getBankprofitamount() {
        return bankprofitamount;
    }

    public void setBankprofitamount(BigInteger bankprofitamount) {
        this.bankprofitamount = bankprofitamount;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getIncomereportsource() {
        return incomereportsource;
    }

    public void setIncomereportsource(String incomereportsource) {
        this.incomereportsource = incomereportsource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VwEarning vwEarning = (VwEarning) o;

        if (!Arrays.equals(guid, vwEarning.guid)) return false;
        if (resSsn != null ? !resSsn.equals(vwEarning.resSsn) : vwEarning.resSsn != null) return false;
        if (ssn != null ? !ssn.equals(vwEarning.ssn) : vwEarning.ssn != null) return false;
        if (firstname != null ? !firstname.equals(vwEarning.firstname) : vwEarning.firstname != null) return false;
        if (lastname != null ? !lastname.equals(vwEarning.lastname) : vwEarning.lastname != null) return false;
        if (fixedearningamount != null ? !fixedearningamount.equals(vwEarning.fixedearningamount) : vwEarning.fixedearningamount != null)
            return false;
        if (bankprofitamount != null ? !bankprofitamount.equals(vwEarning.bankprofitamount) : vwEarning.bankprofitamount != null)
            return false;
        if (jobtitle != null ? !jobtitle.equals(vwEarning.jobtitle) : vwEarning.jobtitle != null) return false;
        if (incomereportsource != null ? !incomereportsource.equals(vwEarning.incomereportsource) : vwEarning.incomereportsource != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(guid);
        result = 31 * result + (resSsn != null ? resSsn.hashCode() : 0);
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (fixedearningamount != null ? fixedearningamount.hashCode() : 0);
        result = 31 * result + (bankprofitamount != null ? bankprofitamount.hashCode() : 0);
        result = 31 * result + (jobtitle != null ? jobtitle.hashCode() : 0);
        result = 31 * result + (incomereportsource != null ? incomereportsource.hashCode() : 0);
        return result;
    }
}
