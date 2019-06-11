package com.codecool.web.service;

import com.codecool.web.model.Product;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ProductsService {

    List<Product> getAll() throws SQLException, SQLException;

    List<Product> getbyName(String name) throws SQLException, SQLException;

    List<Product> getbyBrand(String brand) throws SQLException, SQLException;

    Product getbyId(String prodcutId) throws SQLException, SQLException, ServiceException;

    int countAllProducts() throws SQLException, SQLException;

    Product[] getbyPriceASC() throws SQLException, SQLException;

    Product[] getbyPriceDESC() throws SQLException, SQLException;

    List<Product> getProductByTypeId(String type) throws SQLException, ServiceException;


}
