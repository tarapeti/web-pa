package com.codecool.web.dao.database;

import com.codecool.web.dao.ValuesDao;

import java.sql.Connection;

public class DatabaseValueDao extends AbstractDao implements ValuesDao {
    DatabaseValueDao(Connection connection) {
        super(connection);
    }
}
