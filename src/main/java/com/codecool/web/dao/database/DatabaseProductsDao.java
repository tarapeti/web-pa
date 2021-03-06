package com.codecool.web.dao.database;

import com.codecool.web.dao.ProductsDao;

import com.codecool.web.model.Product;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProductsDao extends AbstractDao implements ProductsDao {
    public DatabaseProductsDao(Connection connection) {
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
    public List<Product> findbyName(String productname) throws SQLException {
        String sql = "SELECT * FROM products WHERE productname = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, productname);
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

    @Override
    public int countAllProducts() throws SQLException {
        String sql = "SELECT COUNT(id) as count FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Product> products = new ArrayList<>();
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        }
        return 0;
    }

    @Override
    public Product[] findbyPriceDESC() throws SQLException {
        Product[] ascending = new Product[countAllProducts()];
        String sql = "SELECT * FROM products ORDER BY (price) DESC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            int count = 0;
            while (resultSet.next()) {
                ascending[count] = fetchProduct(resultSet);
                count++;
            }
            return ascending;
        }
    }


    @Override
    public Product[] findbyPriceASC() throws SQLException {
        Product[] ascending = new Product[countAllProducts()];
        String sql = "SELECT * FROM products ORDER BY (price) ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            int count = 0;
            while (resultSet.next()) {
                ascending[count] = fetchProduct(resultSet);
                count++;
            }
            return ascending;
        }
    }

    @Override
    public List<Product> findProductByTypeId(int typeId) throws SQLException {
        String sql = "SELECT * FROM products INNER JOIN types_table tt on products.type_id = tt.id WHERE tt.id= ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, typeId);
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
    public void addProduct(int typeId, String productname, String brand, int price) throws SQLException {
        String sql = "INSERT INTO products (type_id, productname, brand, price) VALUES (?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, typeId);
            statement.setString(2, productname);
            statement.setString(3, brand);
            statement.setInt(4, price);
            statement.execute();
        }
    }

    private Product fetchProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int typeId = resultSet.getInt("type_id");
        String productname = resultSet.getString("productname");
        String brand = resultSet.getString("brand");
        int price = resultSet.getInt("price");
        return new Product(id, typeId, productname, brand, price);
    }

}
