package com.codecool.web.model;

import java.util.Objects;

public class Order {

    private final int orderId;
    private final int customerId;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() &&
                getCustomerId() == order.getCustomerId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getCustomerId());
    }
}
