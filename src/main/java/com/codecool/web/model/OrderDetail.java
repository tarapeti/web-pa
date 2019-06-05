package com.codecool.web.model;

import java.util.Date;
import java.util.Objects;

public class OrderDetail {

    private final int orderId;
    private final int productId;
    private final int quantity;
    private final int price;
    private final Date date;

    public OrderDetail(int orderId, int productId, int quantity, int price, Date date) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return getOrderId() == that.getOrderId() &&
                getProductId() == that.getProductId() &&
                getQuantity() == that.getQuantity() &&
                getPrice() == that.getPrice() &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getProductId(), getQuantity(), getPrice(), getDate());
    }
}
