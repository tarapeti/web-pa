package com.codecool.web.dao.database;

import com.codecool.web.dao.OrdersDao;
import com.codecool.web.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOrdersDao extends AbstractDao implements OrdersDao {
    DatabaseOrdersDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Order> findAll() throws SQLException {
        String sql = "SELECT * FROM orders";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(fetchOrder(resultSet));
            }
            return orders;
        }
    }

    @Override
    public Order findbyOrderId(int orderId) throws SQLException {
        String sql = "SELECT * FROM orders where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchOrder(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public List<Order> findbyCustomerId(int customerId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            List<Order> orders = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    orders.add(fetchOrder(resultSet));
                }
                return orders;
            }
        }
    }

    private Order fetchOrder(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt("order_id");
        int customerId = resultSet.getInt("customer_id");
        return new Order(orderId, customerId);
    }
}
