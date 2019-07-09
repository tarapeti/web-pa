package com.codecool.web.service;

import com.codecool.web.model.Order;
import com.codecool.web.model.OrderDetail;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface OrdersService {

    List<Order> getAll() throws SQLException;

    Order getbyOrderId(String orderId) throws SQLException, ServiceException;

    List<Order> getbyCustomerId(int customerId) throws SQLException, ServiceException;

    List<OrderDetail> getDetailbyOrderId(int orderId) throws SQLException, ServiceException;

    void order(int userId, String productId, int price, long date) throws SQLException, ServiceException;

}
