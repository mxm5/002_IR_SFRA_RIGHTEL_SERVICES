package com.example.sayehwebservices.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "VW_IVR_YARANEH_STAT", schema = "SAYEH", catalog = "")
public class IvrYaranehStat {

    @Id
    @Basic
    @Column(name = "RES_SSN", nullable = true, length = 10)
    private String resSsn;
    @Basic
    @Column(name = "OLD_STATUS", nullable = true, precision = 0)
    private Long oldStatus;
    @Basic
    @Column(name = "NEW_STATUS", nullable = true, precision = 0)
    private Long newStatus;
    @Basic
    @Column(name = "NEW_DECILE", nullable = true, precision = 0)
    private Long newDecile;
    @Basic
    @Column(name = "HAS_OBJECTION", nullable = true, precision = 0)
    private Long hasObjection;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IvrYaranehStat that = (IvrYaranehStat) o;
        return Objects.equals(resSsn, that.resSsn) && Objects.equals(oldStatus, that.oldStatus) && Objects.equals(newStatus, that.newStatus) && Objects.equals(newDecile, that.newDecile) && Objects.equals(hasObjection, that.hasObjection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resSsn, oldStatus, newStatus, newDecile, hasObjection);
    }
}
