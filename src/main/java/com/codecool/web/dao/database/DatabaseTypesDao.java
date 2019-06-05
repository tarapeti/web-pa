package com.codecool.web.dao.database;

import com.codecool.web.dao.TypesDao;

import java.sql.Connection;

public class DatabaseTypesDao extends AbstractDao implements TypesDao {
    DatabaseTypesDao(Connection connection) {
        super(connection);
    }
}
