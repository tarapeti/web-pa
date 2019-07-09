package com.codecool.web.dao;

import com.codecool.web.model.Order;
import com.codecool.web.model.OrderDetail;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface OrdersDao {
    List<Order> findAll() throws SQLException;

    Order findbyOrderId(int orderId) throws SQLException;

    List<Order> findbyCustomerId(int customerId) throws SQLException;

    OrderDetail findDetailbyOrderId(int orderId) throws SQLException;

    void order(int userId, int productId, int price, long date) throws SQLException;
}
