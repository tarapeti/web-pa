package com.codecool.web.dao;

import com.codecool.web.model.Product;
import com.codecool.web.model.Signature;

import java.sql.SQLException;
import java.util.List;

public interface SignaturesDao {
    List<Signature> findAll() throws SQLException;
    Signature findbyProId(int proId) throws SQLException;
    Product findProductbyDeckId(int deckId) throws SQLException;
    Product findProductbyTruckId(int truckId) throws SQLException;
    Product findProductbyGripId(int gripId) throws SQLException;
    Product findProductbyWheelId(int gripId) throws SQLException;

    Signature findbyDeckId(int deckId) throws SQLException;
    Signature findbyTruckId(int truckId) throws SQLException;
    Signature findbyGripId(int gripId) throws SQLException;
    Signature findbyWheelId(int wheelId) throws SQLException;

}
