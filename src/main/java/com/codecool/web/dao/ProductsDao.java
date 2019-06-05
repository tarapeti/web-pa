package com.codecool.web.dao;

import com.codecool.web.model.Product;
import com.codecool.web.model.Type;

import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

public interface ProductsDao {
    List<Product> findAll() throws SQLException;

    List<Product> findbyName(String name) throws SQLException;

    List<Product> findbyBrand(String brand) throws SQLException;

    Product findbyId(int prodcutId) throws SQLException;

    int countAllProducts() throws SQLException;

    Product[] findbyPriceASC() throws SQLException;

    Product[] findbyPriceDESC() throws SQLException;


}
