package com.codecool.web.dao.database;

import com.codecool.web.dao.OrdersDao;
import com.codecool.web.model.Order;
import com.codecool.web.model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DatabaseOrdersDao extends AbstractDao implements OrdersDao {
    public DatabaseOrdersDao(Connection connection) {
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
        String sql = "SELECT * FROM orders where order_id = ?";
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

    @Override
    public OrderDetail findDetailbyOrderId(int orderId) throws SQLException {
        String sql = "SELECT * FROM order_details WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchOrderDetails(resultSet);
                }
            }
        }
        return null;
    }


    @Override
    public void order(int userId, int productId, int price, long date) throws SQLException {
        String sql = "INSERT INTO order_details(product_id, price, date) VALUES(?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, productId);
            statement.setInt(2, price);
            statement.setLong(3, date);
            statement.execute();

            try (ResultSet resultSet2 = statement.getGeneratedKeys()) {
                if (resultSet2.next()) {
                    int orderId = resultSet2.getInt(1);
                    String sql2 = "INSERT INTO orders(order_id, customer_id) VALUES(?,?)";
                    try (PreparedStatement statement2 = connection.prepareStatement(sql2)) {
                        statement2.setInt(1, orderId);
                        statement2.setInt(2, userId);
                        statement2.execute();
                    }

                } else {
                    throw new SQLException("Expected 1 result");
                }
            }
        }

    }


    private Order fetchOrder(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt("order_id");
        int customerId = resultSet.getInt("customer_id");
        return new Order(orderId, customerId);
    }

    private OrderDetail fetchOrderDetails(ResultSet resultSet) throws SQLException{
        int orderId = resultSet.getInt("order_id");
        int productId = resultSet.getInt("product_id");
        int price = resultSet.getInt("price");
        long date = resultSet.getLong("date");
        return new OrderDetail(orderId, productId, price, date);
    }
}
