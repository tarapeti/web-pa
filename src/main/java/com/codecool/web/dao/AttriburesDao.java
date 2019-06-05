package com.codecool.web.dao;

import com.codecool.web.model.Attribure;

import java.sql.SQLException;
import java.util.List;

public interface AttriburesDao {
    List<Attribure> findAll()throws SQLException;
    Attribure findbyId(int attributeId) throws SQLException;
    List<Attribure> findbyType(String type)throws SQLException;
}
