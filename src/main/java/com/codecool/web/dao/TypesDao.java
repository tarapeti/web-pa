package com.codecool.web.dao;

import com.codecool.web.model.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypesDao {

    List<Type> findAll() throws SQLException;

    Type findbyId(int typeId) throws SQLException;

    List<Type> findbyName(String name) throws SQLException;

    Type findTypebyProductId(int prodId) throws SQLException;
}
