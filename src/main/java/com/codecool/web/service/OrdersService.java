package com.codecool.web.service;

import com.codecool.web.model.Order;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface OrdersService {

    List<Order> getAll() throws SQLException;

    Order findbyOrderId(String orderId) throws SQLException, ServiceException;

    List<Order> findbyCustomerId(String customerId) throws SQLException, ServiceException;
}
