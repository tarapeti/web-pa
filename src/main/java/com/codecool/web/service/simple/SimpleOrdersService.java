package com.codecool.web.service.simple;

import com.codecool.web.dao.OrdersDao;
import com.codecool.web.model.Order;
import com.codecool.web.model.OrderDetail;
import com.codecool.web.service.OrdersService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.ArrayList;
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
    public Order getbyOrderId(String orderId) throws SQLException, ServiceException {
        try {
            return ordersDao.findbyOrderId(Integer.parseInt(orderId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("orderId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<Order> getbyCustomerId(int customerId) throws SQLException, ServiceException {
        try {
            return ordersDao.findbyCustomerId(customerId);
        }  catch (NumberFormatException ex) {
            throw new ServiceException("orderId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public OrderDetail getDetailbyOrderId(int orderId) throws SQLException, ServiceException {
        try {
            return ordersDao.findDetailbyOrderId(orderId);
        }  catch (NumberFormatException ex) {
            throw new ServiceException("orderId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void order(int userId, String productId, int price, long date) throws SQLException, ServiceException {
        try {
            ordersDao.order(userId, Integer.parseInt(productId), price, date);
        }  catch (NumberFormatException ex) {
            throw new ServiceException("orderId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<OrderDetail> findOrderDetailsForEachOrder(List<Order> orders) throws SQLException {
        List<OrderDetail> orderDetails = new ArrayList<>();
        for(Order order : orders){
            orderDetails.add(ordersDao.findDetailbyOrderId(order.getOrderId()));
        }
        return orderDetails;
    }
}
