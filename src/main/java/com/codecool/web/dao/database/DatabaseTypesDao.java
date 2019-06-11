package com.codecool.web.dao.database;

import com.codecool.web.dao.TypesDao;
import com.codecool.web.model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTypesDao extends AbstractDao implements TypesDao {
    public DatabaseTypesDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Type> findAll() throws SQLException {
        String sql = "SELECT * FROM types_table";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Type> types = new ArrayList<>();
            while (resultSet.next()) {
                types.add(fetchType(resultSet));
            }
            return types;
        }
    }

    @Override
    public Type findbyId(int typeId) throws SQLException {
        String sql = "SELECT * FROM types_table where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, typeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchType(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public List<Type> findbyName(String name) throws SQLException {
        String sql = "SELECT * FROM types_table where typename =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            List<Type> types = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    types.add(fetchType(resultSet));
                }
                return types;
            }
        }
    }

    @Override
    public Type findTypebyProductId(int prodId) throws SQLException {
        String sql = "SELECT * FROM types_table INNER JOIN products p on types_table.id = p.type_id WHERE p.type_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, prodId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchType(resultSet);
                }
            }
        }
        return null;
    }

    private Type fetchType(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Type(id, name);
    }
}
