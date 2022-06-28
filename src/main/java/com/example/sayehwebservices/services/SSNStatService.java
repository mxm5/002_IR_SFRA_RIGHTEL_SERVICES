package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.SSNStat;
import com.example.sayehwebservices.repository.SSNSStatRepository;
import com.example.sayehwebservices.services.dto.AccessResponse;
import com.example.sayehwebservices.services.dto.AppAccess;
import com.example.sayehwebservices.services.dto.SSNStatResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.JDBCType.STRUCT;

@Service
@Slf4j
public class SSNStatService {

    @Autowired
    SSNSStatRepository ssnsStatRepository;

    public SSNStatResponseDto getForPersonByNationalCode(String nationalCode) {
        SSNStat statusByNationalCode = ssnsStatRepository.getStatusByNationalCode(
                nationalCode
        );


        if (statusByNationalCode != null) {

            if (statusByNationalCode.getSsnStat() == 1) {
                return new SSNStatResponseDto(
                        "این کد ملی به عنوان سرپرست در سامانه ثبت شده است",
                        1,
                        statusByNationalCode.getDecile(),
                        statusByNationalCode.getMashmool() == 1

                );
            } else {
                return new SSNStatResponseDto(
                        "این کد ملی به عنوان فرد غیر سرپرست ثبت شده میباشد",
                        2,
                        statusByNationalCode.getDecile(),
                        statusByNationalCode.getMashmool() == 1

                );
            }
        } else {
            return new SSNStatResponseDto(
                    "این کد ملی در سامانه ثبت نشده است",
                    0,
                    -1);
        }


    }

    @PersistenceContext
    private EntityManager entityManager;

    public AccessResponse getAccessFromOracleFunction(String nationalCode) throws Exception {

        if (nationalCode.isBlank() || nationalCode.isEmpty()) {
            throw new Exception("کد ملی دریافت نشد");
        }

        // getting function
        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("REFAHDB.PKG_OBJECTION.PRC_REGISTER");
        // defining parameters in function
        procedure.registerStoredProcedureParameter("P_IN_SSN", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("P_OUT_ENTERANCE", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_MESSAGE", String.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_PRIVS", String.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_RESPONSE_CODE", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_RESPONSE_DESC", String.class, ParameterMode.OUT);
        // passing input values
        procedure.setParameter("P_IN_SSN", nationalCode);
        // run
        procedure.execute();
        // extracting values
        String p_out_message = (String) procedure.getOutputParameterValue("P_OUT_MESSAGE");
        Integer p_out_enterance = (Integer) procedure.getOutputParameterValue("P_OUT_ENTERANCE");
        String p_out_privs = (String) procedure.getOutputParameterValue("P_OUT_PRIVS");
        Integer p_response_code = (Integer) procedure.getOutputParameterValue("P_RESPONSE_CODE");
        String p_response_desc = (String) procedure.getOutputParameterValue("P_RESPONSE_DESC");
        //split
        String[] split = p_out_privs.split("");
        //
        AppAccess can_view_decile = new AppAccess("can_view_decile", Objects.equals(split[0], "1"));
        AppAccess can_view_family_info = new AppAccess("can_view_family_info", Objects.equals(split[1], "1"));
        AppAccess can_view_economic_info = new AppAccess("can_view_economic_info", Objects.equals(split[2], "1"));
        AppAccess can_submit_objection = new AppAccess("can_submit_objection", Objects.equals(split[3], "1"));
        AppAccess can_register_for_subsidy = new AppAccess("can_register_for_subsidy", Objects.equals(split[4], "1"));


        List<AppAccess> accessList = new ArrayList<>(List.of(
                can_submit_objection,
                can_view_decile,
                can_register_for_subsidy,
                can_view_family_info,
                can_view_economic_info
        ));


        return new AccessResponse(
                accessList, p_out_message, p_out_enterance==1
        );

    }


}
