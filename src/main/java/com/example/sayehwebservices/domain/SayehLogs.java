package com.example.sayehwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Rightel_Logs")
public class SayehLogs {
    @Id
    @GeneratedValue
    @ColumnDefault("RAWTOHEX(sys_guid() ) ")
    @Column(name = "id", length = 1000)
    private UUID id;

//    @ColumnDefault("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS','nls_calendar=persian')")
    @Column(name = "local_date_time", nullable = false)
    private LocalDateTime localDateTime;

    @Column(name = "national_code", nullable = false, length = 10)
    private String nationalCode;

    @Column(name = "service_name",length = 1000)
    private String serviceName;

    @Column(name = "successful_result")
    @ColumnDefault("0")
    private Boolean successfulResult;

    @Column(name = "sayeh_principle",length = 1000)
    private String principle;

}