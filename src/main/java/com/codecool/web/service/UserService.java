package com.codecool.web.service;

import com.codecool.web.model.User;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User getByEmail(String email) throws SQLException;

    List<User> getAll() throws SQLException;

    List<User> getbyRole(String role) throws SQLException, ServiceException;
}
