package com.codecool.web.dao.database;

import com.codecool.web.dao.ProductsDao;

import java.sql.Connection;

public class DatabaseProductsDao extends AbstractDao implements ProductsDao {
    DatabaseProductsDao(Connection connection) {
        super(connection);
    }
}
