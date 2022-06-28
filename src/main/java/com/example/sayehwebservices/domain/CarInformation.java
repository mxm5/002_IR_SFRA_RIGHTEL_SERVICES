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
@Table(name = "VW_CAR", schema = "SAYEH", catalog = "")
public class CarInformation {
    @Id
    @Basic
    @Column(name = "GUID", nullable = true)
    private String  guid;
    @Basic
    @Column(name = "RES_SSN", nullable = true, precision = 0)
    private Long resSsn;
    @Basic
    @Column(name = "OWNER_SSN", nullable = true, length = 3)
    private Long ownerSsn;
    @Basic
    @Column(name = "FIRSTNAME", nullable = true, length = 100)
    private String firstname;
    @Basic
    @Column(name = "LASTNAME", nullable = true, length = 5)
    private String lastname;
    @Basic
    @Column(name = "CARTYPE", nullable = true, length = 100)
    private String cartype;
    @Basic
    @Column(name = "CARCATEGORY", nullable = true, length = 100)
    private String carcategory;
    @Basic
    @Column(name = "IDN1", nullable = true, length = 12)
    private String idn1;
    @Basic
    @Column(name = "PLAK_DESC", nullable = true, length = 12)
    private String plakDesc;
    @Basic
    @Column(name = "MANYEAR", nullable = true, precision = 0)
    private Short manyear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarInformation that = (CarInformation) o;
        return Objects.equals(resSsn, that.resSsn) && Objects.equals(ownerSsn, that.ownerSsn) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(cartype, that.cartype) && Objects.equals(carcategory, that.carcategory) && Objects.equals(idn1, that.idn1) && Objects.equals(plakDesc, that.plakDesc) && Objects.equals(manyear, that.manyear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resSsn, ownerSsn, firstname, lastname, cartype, carcategory, idn1, plakDesc, manyear);
    }
}
