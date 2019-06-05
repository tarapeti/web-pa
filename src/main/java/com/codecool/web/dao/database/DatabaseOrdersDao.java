package com.codecool.web.dao.database;

import com.codecool.web.dao.OrdersDao;

import java.sql.Connection;

public class DatabaseOrdersDao extends AbstractDao implements OrdersDao {
    DatabaseOrdersDao(Connection connection) {
        super(connection);
    }
}
