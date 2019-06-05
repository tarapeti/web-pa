package com.codecool.web.dao.database;

import com.codecool.web.dao.AttriburesDao;

import java.sql.Connection;

public class DatabaseAttriburesDao extends AbstractDao implements AttriburesDao {
    DatabaseAttriburesDao(Connection connection) {
        super(connection);
    }
}
