package com.codecool.web.dao.database;

import com.codecool.web.dao.UserDao;
import com.codecool.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseUserDao extends AbstractDao implements UserDao {

    public DatabaseUserDao(Connection connection) {
        super(connection);
    }

    public List<User> findAll() throws SQLException {
        String sql = "SELECT id,username, email, password, role FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(fetchUser(resultSet));
            }
            return users;
        }
    }

    @Override
    public List<User> findbyRole(boolean role) throws SQLException {
        String sql = "SELECT * FROM users WHERE role = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, role);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    users.add(fetchUser(resultSet));
                }
                return users;
            }
        }
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        if (email == null || "".equals(email)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchUser(resultSet);
                }
            }
        }
        return null;
    }

    private User fetchUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        boolean role = resultSet.getBoolean("role");
        return new User(id, email, password);
    }
}
