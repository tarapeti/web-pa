package com.codecool.web.service;

import com.codecool.web.model.Value;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ValueService {
    List<Value> getAll() throws SQLException;

    Value getbyAttributeId(String attributeId) throws SQLException, ServiceException;

    Value getbyProductId(String productId) throws SQLException, ServiceException;

    String stringValuebyAttibuteId(String attributeId) throws SQLException, ServiceException;

    int intValuebyAttributeId(String attributeId) throws SQLException, ServiceException;

    boolean booleanValuebyAttributeId(String attributeId) throws SQLException, ServiceException;
}
