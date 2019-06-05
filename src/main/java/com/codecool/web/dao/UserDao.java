package com.codecool.web.dao;

import com.codecool.web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    User findByEmail(String email) throws SQLException;

    List<User> findAll() throws SQLException;

    List<User> findbyRole(boolean role) throws SQLException;
}
