package com.codecool.web.dao.database;

import com.codecool.web.dao.AttriburesDao;
import com.codecool.web.model.Attribure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAttriburesDao extends AbstractDao implements AttriburesDao {
    DatabaseAttriburesDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Attribure> findAll() throws SQLException {
        String sql = "SELECT * FROM attributes_table";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Attribure> attribures = new ArrayList<>();
            while (resultSet.next()) {
                attribures.add(fetchAttribure(resultSet));
            }
            return attribures;
        }
    }

    @Override
    public Attribure findbyId(int attributeId) throws SQLException {
        String sql = "SELECT * FROM attributes_table WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, attributeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchAttribure(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public List<Attribure> findbyType(String type) throws SQLException {
        String sql = "SELECT * FROM attributes_table WHERE value_type =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type);
            List<Attribure> attribures = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    attribures.add(fetchAttribure(resultSet));
                }
                return attribures;
            }
        }
    }


    private Attribure fetchAttribure(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("attribure_name");
        String type = resultSet.getString("value_type");
        return new Attribure(id, name, type);
    }
}
