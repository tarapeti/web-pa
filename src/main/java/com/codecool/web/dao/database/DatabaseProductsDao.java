package com.codecool.web.dao.database;

import com.codecool.web.dao.ProductsDao;
import com.codecool.web.model.Attribure;
import com.codecool.web.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProductsDao extends AbstractDao implements ProductsDao {
    DatabaseProductsDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> findAll() throws SQLException {
        String sql = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(fetchProduct(resultSet));
            }
            return products;
        }
    }

    @Override
    public List<Product> findbyName(String name) throws SQLException {
        String sql = "SELECT * FROM products WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            List<Product> products = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    products.add(fetchProduct(resultSet));
                }
                return products;
            }
        }
    }

    @Override
    public List<Product> findbyBrand(String brand) throws SQLException {
        String sql = "SELECT * FROM products WHERE brand = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, brand);
            List<Product> products = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    products.add(fetchProduct(resultSet));
                }
                return products;
            }
        }
    }

    @Override
    public Product findbyId(int prodcutId) throws SQLException {
        String sql = "SELECT * FROM products where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, prodcutId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchProduct(resultSet);
                }
            }
        }
        return null;
    }

    private Product fetchProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int typeId = resultSet.getInt("type_id");
        String name = resultSet.getString("name");
        String brand = resultSet.getString("brand");
        int price = resultSet.getInt("price");
        return new Product(id, typeId, name, brand, price);
    }
}
