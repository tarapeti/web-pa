package com.codecool.web.dto;

import com.codecool.web.model.Product;

import java.util.List;

public class ProductsDto {

    private final List<Product> products;

    public ProductsDto(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
