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
@Table(name = "VW_CV_REGINFO", schema = "SAYEH", catalog = "")
public class VwCvReginfo {
    @Id
    @Basic
    @Column(name = "NATIONALCODE", nullable = false, precision = 0)
    private BigInteger nationalcode;
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

    public BigInteger getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(BigInteger nationalcode) {
        this.nationalcode = nationalcode;
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

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getGenderid() {
        return genderid;
    }

    public void setGenderid(Boolean genderid) {
        this.genderid = genderid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VwCvReginfo that = (VwCvReginfo) o;

        if (nationalcode != null ? !nationalcode.equals(that.nationalcode) : that.nationalcode != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (fathername != null ? !fathername.equals(that.fathername) : that.fathername != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (genderid != null ? !genderid.equals(that.genderid) : that.genderid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nationalcode != null ? nationalcode.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (fathername != null ? fathername.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (genderid != null ? genderid.hashCode() : 0);
        return result;
    }
}
