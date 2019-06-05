package com.codecool.web.dao;

import com.codecool.web.model.Value;

import java.sql.SQLException;
import java.util.List;

public interface ValuesDao {
    List<Value> findAll() throws SQLException;
    Value findbyAttributeId(int attributeId) throws SQLException;
    String stringValuebyAttibuteId(int attributeId) throws SQLException;
    int intValuebyAttributeId(int attributeId) throws SQLException;
    boolean booleanValuebyAttributeId(int attributeId) throws SQLException;

}
