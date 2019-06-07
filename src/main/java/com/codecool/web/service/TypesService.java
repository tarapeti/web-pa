package com.codecool.web.service;

import com.codecool.web.model.Type;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface TypesService {

    List<Type> getAll() throws SQLException;

    Type getbyId(String typeId) throws SQLException, ServiceException;

    List<Type> getbyName(String name) throws SQLException;

    Type getProductbyType(String prodId) throws SQLException, ServiceException;
}
