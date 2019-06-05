package com.codecool.web.dao.database;

import com.codecool.web.dao.SignaturesDao;

import java.sql.Connection;

public class DatabaseSignaturesDao extends AbstractDao implements SignaturesDao {
    DatabaseSignaturesDao(Connection connection) {
        super(connection);
    }
}
