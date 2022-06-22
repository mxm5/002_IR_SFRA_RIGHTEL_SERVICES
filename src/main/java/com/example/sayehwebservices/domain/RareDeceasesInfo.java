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
@Table(name = "VW_RAREDEASES", schema = "SAYEH", catalog = "")
public class RareDeceasesInfo {
//    @Id
//    @Basic
//    @Column(name = "GUID", nullable = true)
//    private String  guid;
    @Id // TODO:
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
    @Column(name = "BIMARYGROUP", nullable = true, length = 100)
    private String bimarygroup;
    @Basic
    @Column(name = "BIMARYTYPE", nullable = true, length = 100)
    private String bimarytype;
    @Basic
    @Column(name = "BIMARKHAS_SOURCE", nullable = true, length = 100)
    private String bimarkhasSource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RareDeceasesInfo that = (RareDeceasesInfo) o;
        return Objects.equals(resSsn, that.resSsn) && Objects.equals(ssn, that.ssn) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(bimarygroup, that.bimarygroup) && Objects.equals(bimarytype, that.bimarytype) && Objects.equals(bimarkhasSource, that.bimarkhasSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resSsn, ssn, firstname, lastname, bimarygroup, bimarytype, bimarkhasSource);
    }
}
