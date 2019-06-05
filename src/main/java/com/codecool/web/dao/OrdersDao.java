package com.codecool.web.dao;

import com.codecool.web.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDao {
    List<Order> findAll() throws SQLException;
    Order findbyOrderId(int orderId) throws SQLException;
    List<Order> findbyCustomerId(int customerId) throws SQLException;

}
