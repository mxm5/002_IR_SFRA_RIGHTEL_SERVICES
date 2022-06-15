package com.example.sayehwebservices.services;

import com.example.sayehwebservices.domain.SSNStat;
import com.example.sayehwebservices.repository.SSNSStatRepository;
import com.example.sayehwebservices.services.dto.SSNStatResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.List;

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


    // define the stored procedure
//StoredProcedureQuery query = this.em.createStoredProcedureQuery("calculate");
//query.registerStoredProcedureParameter("x", Double.class, ParameterMode.IN);
//query.registerStoredProcedureParameter("y", Double.class, ParameterMode.IN);
//query.registerStoredProcedureParameter("sum", Double.class, ParameterMode.OUT);
    public void getShit(String nationalCode) {

        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("REFAHDB.PKG_OBJECTION.PRC_REGISTER2");
        procedure.registerStoredProcedureParameter("P_IN_SSN", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("P_OUT_MESSAGE", String.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_ENTERANCE", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_PRIVS", String.class, ParameterMode.OUT);
//
// set input parameter
//        query.setParameter("x", 1.23d);
//        query.setParameter("y", 4.56d);

// call the stored procedure and get the result
//        query.execute();
//        Double sum = (Double) query.getOutputParameterValue("sum");
        procedure.setParameter("P_IN_SSN", "1111111111");
        procedure.execute();
        String p_out_message = (String) procedure.getOutputParameterValue("P_OUT_MESSAGE");
        Integer p_out_enterance = (Integer) procedure.getOutputParameterValue("P_OUT_ENTERANCE");
        String p_out_privs = (String) procedure.getOutputParameterValue("P_OUT_PRIVS");
        System.out.println(
                "\np_out_message\n" + p_out_message + " " +
                        "\np_out_enterance\n" + p_out_enterance + " " +
                        "\np_out_privs\n" + p_out_privs + " "
        );
    }

    public void getShitB(String nationalCode) {

        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("REFAHDB.PKG_OBJECTION.PRC_REGISTER");
        procedure.registerStoredProcedureParameter("P_IN_SSN", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("P_OUT_MESSAGE", String.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_ENTERANCE", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_PRIVS", Object[].class, ParameterMode.OUT);
//
// set input parameter
//        query.setParameter("x", 1.23d);
//        query.setParameter("y", 4.56d);

// call the stored procedure and get the result
//        query.execute();
//        Double sum = (Double) query.getOutputParameterValue("sum");
        procedure.setParameter("P_IN_SSN", "1111111111");
        procedure.execute();
        String p_out_message = (String) procedure.getOutputParameterValue("P_OUT_MESSAGE");
        Integer p_out_enterance = (Integer) procedure.getOutputParameterValue("P_OUT_ENTERANCE");
        Object[] p_out_privs = (Object[])
                procedure.getOutputParameterValue("P_OUT_PRIVS");
        System.out.println(
                "\np_out_message\n" + p_out_message + " " +
                        "\np_out_enterance\n" + p_out_enterance + " " +
                        "\np_out_privs\n" + p_out_privs + " "
        );
    }

    public void getShitC(String nationalCode) {

        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("REFAHDB.PKG_OBJECTION.PRC_REGISTER");
        procedure.registerStoredProcedureParameter("P_IN_SSN", String.class, ParameterMode.IN);
//        procedure.registerStoredProcedureParameter("P_OUT_MESSAGE", String.class, ParameterMode.OUT);
//        procedure.registerStoredProcedureParameter("P_OUT_ENTERANCE", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_PRIVS", Object[].class, ParameterMode.OUT);
//
// set input parameter
//        query.setParameter("x", 1.23d);
//        query.setParameter("y", 4.56d);

// call the stored procedure and get the result
//        query.execute();
//        Double sum = (Double) query.getOutputParameterValue("sum");
        procedure.setParameter("P_IN_SSN", "1111111111");
        boolean execute = procedure.execute();
        List<Object> resultList = procedure.getResultList();
        resultList.forEach(System.out::println);

//        String p_out_message = (String) procedure.getOutputParameterValue("P_OUT_MESSAGE");
//        Integer p_out_enterance = (Integer) procedure.getOutputParameterValue("P_OUT_ENTERANCE");
//        Object[] p_out_privs = (Object[])
//                procedure.getOutputParameterValue("P_OUT_PRIVS");
//        System.out.println(
//                "\np_out_message\n" + p_out_message + " " +
//                        "\np_out_enterance\n" + p_out_enterance + " " +
//                        "\np_out_privs\n" + p_out_privs + " "
//        );
    }

    @Transactional // No transactional EntityManager available
    public void gsd() {
//        java.sql.Connection connection = entityManager.unwrap(java.sql.Connection.class);
//        Session session = (Session) em.getDelegate();
//        SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
//        ConnectionProvider cp = sfi.getConnectionProvider();
//        Connection connection = cp.getConnection();
//        Connection conn = (Connection) entityManager.unwrap(java.sql.Connection.class);// https://blog.krybot.com/a?ID=01500-d67fac17-a7d6-47db-a6b8-622981e36954
        Connection connection = entityManager.unwrap(SessionImpl.class).connection();

       if(1==2) {
            try {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("call REFAHDB.PKG_OBJECTION.PRC_REGISTER('1111111111',p_out_privs=>:p_out_privs)");
                java.sql.Struct jdbcStruct = (java.sql.Struct) resultSet.getObject(1);
                System.out.println(jdbcStruct);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {

            CallableStatement callableStatement = connection.prepareCall("{call REFAHDB.PKG_OBJECTION.PRC_REGISTER(?,?)}");
            callableStatement.setString(1,"1111111111");
            callableStatement.registerOutParameter(2, STRUCT, "EMP_OBJECT");
            callableStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
