package com.codecool.web.model;

import java.util.Date;
import java.util.Objects;

public class OrderDetail {

    private final int orderId;
    private final int productId;
    private final int price;
    private final long date;

    public OrderDetail(int orderId, int productId, int price, long date) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    public long getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return getOrderId() == that.getOrderId() &&
                getProductId() == that.getProductId() &&
                getPrice() == that.getPrice() &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getProductId(), getPrice(), getDate());
    }
}
