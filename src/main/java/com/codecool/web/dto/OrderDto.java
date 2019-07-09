package com.codecool.web.dto;

import com.codecool.web.model.Order;
import com.codecool.web.model.OrderDetail;

import java.util.List;

public class OrderDto {
    private final List<Order> order;
    private final List<OrderDetail> orderDetail;

    public OrderDto(List<Order> order, List<OrderDetail> orderDetail) {
        this.order = order;
        this.orderDetail = orderDetail;
    }

    public List<Order> getOrder() {
        return order;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }
}
