package com.codecool.web.dao.database;

import com.codecool.web.dao.ValuesDao;
import com.codecool.web.model.Value;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseValueDao extends AbstractDao implements ValuesDao {
    DatabaseValueDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Value> findAll() throws SQLException {
        String sql = "SELECT * FROM values_table";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Value> values = new ArrayList<>();
            while (resultSet.next()) {
                values.add(fetchValue(resultSet));
            }
            return values;
        }
    }

    @Override
    public Value findbyAttributeId(int attributeId) throws SQLException {
        String sql = "SELECT * FROM values_table where attribute_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, attributeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchValue(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Value findbyProductId(int productId) throws SQLException {
        String sql = "SELECT * FROM values_table where product_id= ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchValue(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public String stringValuebyAttibuteId(int attributeId) throws SQLException {
        String sql = "SELECT value_string as sValue FROM values_table where value_string = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, attributeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("sValue");
                }
            }
        }
        return null;
    }

    @Override
    public int intValuebyAttributeId(int attributeId) throws SQLException {
        String sql = "SELECT value_int as iValue FROM values_table where value_int = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, attributeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("iValue");
                }
            }
        }
        return 0;
    }

    @Override
    public boolean booleanValuebyAttributeId(int attributeId) throws SQLException {
        String sql = "SELECT value_bool as bValue FROM values_table where value_bool= ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, attributeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBoolean("bValue");
                }
            }
        }
        return false;
    }

    private Value fetchValue(ResultSet resultSet) throws SQLException {
        int attributeId = resultSet.getInt("attribute_id");
        int productId = resultSet.getInt("product_id");
        String valueString = resultSet.getString("value_string");
        int valueInt = resultSet.getInt("value_it");
        boolean valueBool = resultSet.getBoolean("value_bool");
        return new Value(attributeId, productId, valueInt, valueString, valueBool);
    }
}
