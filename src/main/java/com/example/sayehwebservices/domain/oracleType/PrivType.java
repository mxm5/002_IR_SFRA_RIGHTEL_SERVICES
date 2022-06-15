package com.example.sayehwebservices.domain.oracleType;

import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;

import static java.sql.Types.STRUCT;

/**
 * **
 * Usage in Entity
 *
 * @Column(name="TABLE_NAME", columnDefinition="CUSTOMER_ADDRESS")
 * @Type(type= "com.example.demo.PrivType")
 * private Address address;
 */

//
//
//
//
//
//
//      create type CUSTOMER_ADDRESS as object
//      (
//        STREET_ADDRESS   VARCHAR2(50),
//        CITY             VARCHAR2(20)
//      )
//
//
//
//
//
//
//
//
//
//
//

public class PrivType implements UserType {

    private static final int SQL_TYPE = STRUCT;
    private static final String DB_OBJECT_TYPE = "CUSTOMER_ADDRESS"; //DB custom type name

    @Override
    public int[] sqlTypes() {
        return new int[]{SQL_TYPE};
    }

    @Override
    public Class returnedClass() {
        return Address.class;
    }

    @Override
    public Address nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        final Struct struct = (Struct) rs.getObject(names[0]);

        if (rs.wasNull()) {
            return null;
        }

        final Address address = new Address();
        address.streetAddress = (String) struct.getAttributes()[0];
        address.city = (String) struct.getAttributes()[1];

        return address;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value != null) {
            final Address address = (Address) value;
            final Struct address2 = st.getConnection().createStruct(DB_OBJECT_TYPE, new Object[]{
                    address.streetAddress,
                    address.city
            });
            st.setObject(index, address, SQL_TYPE);
        } else {
            st.setNull(index, SQL_TYPE, DB_OBJECT_TYPE);
        }
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return ((x == y) || (x != null && y != null && x.equals(y)));
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x != null ? x.hashCode() : 0;
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value == null ? null : value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        Object deepCopy = deepCopy(value);
        if (!(deepCopy instanceof Serializable)) {
            return (Serializable) deepCopy;
        }
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }
}


@Data
class Address {
    String streetAddress;
    String city;
}