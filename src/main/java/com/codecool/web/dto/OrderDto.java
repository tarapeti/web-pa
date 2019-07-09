package com.codecool.web.dto;

import com.codecool.web.model.Order;
import com.codecool.web.model.OrderDetail;

public class OrderDto {
    private final Order order;
    private final OrderDetail orderDetail;


    public OrderDto(Order order, OrderDetail orderDetail) {
        this.order = order;
        this.orderDetail = orderDetail;
    }

    public Order getOrder() {
        return order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }
}
