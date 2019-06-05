package com.codecool.web.model;

import java.util.Objects;

public class Product extends AbstractModel {

    private final int typeId;
    private final String name;
    private final String brand;
    private final int price;

    public Product(int id, int typeId, String name, String brand, int price) {
        super(id);
        this.typeId = typeId;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return getTypeId() == product.getTypeId() &&
                getPrice() == product.getPrice() &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getBrand(), product.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTypeId(), getName(), getBrand(), getPrice());
    }
}
