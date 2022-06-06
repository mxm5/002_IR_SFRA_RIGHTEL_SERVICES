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
@Table(name = "VW_RAREDEASES", schema = "SAYEH", catalog = "")
public class VwRaredeases {
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
    @Column(name = "BIMARYGROUP", nullable = true, length = 100)
    private String bimarygroup;
    @Basic
    @Column(name = "BIMARYTYPE", nullable = true, length = 100)
    private String bimarytype;
    @Basic
    @Column(name = "BIMARKHAS_SOURCE", nullable = true, length = 100)
    private String bimarkhasSource;

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

    public String getBimarygroup() {
        return bimarygroup;
    }

    public void setBimarygroup(String bimarygroup) {
        this.bimarygroup = bimarygroup;
    }

    public String getBimarytype() {
        return bimarytype;
    }

    public void setBimarytype(String bimarytype) {
        this.bimarytype = bimarytype;
    }

    public String getBimarkhasSource() {
        return bimarkhasSource;
    }

    public void setBimarkhasSource(String bimarkhasSource) {
        this.bimarkhasSource = bimarkhasSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VwRaredeases that = (VwRaredeases) o;

        if (resSsn != null ? !resSsn.equals(that.resSsn) : that.resSsn != null) return false;
        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (bimarygroup != null ? !bimarygroup.equals(that.bimarygroup) : that.bimarygroup != null) return false;
        if (bimarytype != null ? !bimarytype.equals(that.bimarytype) : that.bimarytype != null) return false;
        if (bimarkhasSource != null ? !bimarkhasSource.equals(that.bimarkhasSource) : that.bimarkhasSource != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resSsn != null ? resSsn.hashCode() : 0;
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (bimarygroup != null ? bimarygroup.hashCode() : 0);
        result = 31 * result + (bimarytype != null ? bimarytype.hashCode() : 0);
        result = 31 * result + (bimarkhasSource != null ? bimarkhasSource.hashCode() : 0);
        return result;
    }
}
