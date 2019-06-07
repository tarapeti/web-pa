package com.codecool.web.service;

import com.codecool.web.model.Attribure;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface AttributesService {
    List<Attribure> getAll() throws SQLException, ServiceException;

    Attribure getbyId(String attributeId) throws SQLException, ServiceException;

    List<Attribure> getbyType(String type) throws SQLException, ServiceException;
}
