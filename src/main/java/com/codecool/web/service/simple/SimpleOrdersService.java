package com.codecool.web.service.simple;

import com.codecool.web.dao.OrdersDao;
import com.codecool.web.model.Order;
import com.codecool.web.service.OrdersService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleOrdersService implements OrdersService {

    private final OrdersDao ordersDao;

    public SimpleOrdersService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return ordersDao.findAll();
    }

    @Override
    public Order findbyOrderId(String orderId) throws SQLException, ServiceException {
        try {
            return ordersDao.findbyOrderId(Integer.parseInt(orderId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("orderId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<Order> findbyCustomerId(String customerId) throws SQLException, ServiceException {
        try {
            return ordersDao.findbyCustomerId(Integer.parseInt(customerId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("orderId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
