package com.codecool.web.service.simple;

import com.codecool.web.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleUsersService implements UserService {
    private final UserDao userDao;

    public SimpleUsersService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getByEmail(String email) throws SQLException {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userDao.findAll();
    }

    @Override
    public List<User> getbyRole(String role) throws SQLException, ServiceException {
        try {
            return userDao.findbyRole(Boolean.parseBoolean(role));
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public User getbyId(int userId) throws SQLException, ServiceException {
        return userDao.findById(userId);
    }

    @Override
    public void addNewUser(String name, String email, String password) throws SQLException, ServiceException {
        userDao.addNewUser(name, email, password);
    }
}
