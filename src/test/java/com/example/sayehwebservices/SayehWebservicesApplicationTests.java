package com.example.sayehwebservices;

import com.example.sayehwebservices.repository.SSNSStatRepository;
import org.hibernate.internal.SessionImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.List;

import static java.sql.JDBCType.STRUCT;

@SpringBootTest
class SayehWebservicesApplicationTests {

    @Autowired
    Tester service;

    @Autowired
    SSNSStatRepository ssnsStatRepository;

    @Test
    void contextLoads() {
        Integer g = ssnsStatRepository.checkNationalCodeValidity("2740903499");
        System.out.println(g==1);
//       service.getShitC("1111111111");
//        service.gsd();
//        service.getShit("2740903499");
    }

}



@Configuration
class Tester{

    @PersistenceContext
    private EntityManager entityManager;





    public void getShit(String nationalCode) {

        StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("REFAHDB.PKG_OBJECTION.PRC_REGISTER2");
        procedure.registerStoredProcedureParameter("P_IN_SSN", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("P_OUT_ENTERANCE", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_MESSAGE", String.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_OUT_PRIVS", String.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_RESPONSE_CODE", Integer.class, ParameterMode.OUT);
        procedure.registerStoredProcedureParameter("P_RESPONSE_DESC", String.class, ParameterMode.OUT);
//
//        p_in_ssn        in varchar2,
//        p_out_enterance out number,
//        p_out_message   out varchar2,
//        p_out_privs     out varchar2,
//        p_response_code out number,
//        p_response_desc out varchar2
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
        Integer p_response_code = (Integer) procedure.getOutputParameterValue("P_RESPONSE_CODE");
        String p_response_desc = (String) procedure.getOutputParameterValue("P_RESPONSE_DESC");

        System.out.println(
                "\np_out_message\n" + p_out_message + " " +
                        "\np_out_enterance\n" + p_out_enterance + " " +
                        "\np_out_privs\n" + p_out_privs + " " +
                        "\np_response_code\n" + p_response_code + " " +
                        "\np_response_desc\n" + p_response_desc + " "

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

        if (1 == 2) {
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
            callableStatement.setString(1, "1111111111");
            callableStatement.registerOutParameter(2, STRUCT, "EMP_OBJECT");
            callableStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}