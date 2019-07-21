package com.codecool.web.service;

import com.codecool.web.dto.SignaturesDto;
import com.codecool.web.model.Product;
import com.codecool.web.model.Signature;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface SignaturesService {
    List<Signature> getAll() throws SQLException;

    Signature getbyProId(String proId) throws SQLException, ServiceException;

    Product getProductbyDeckId(String deckId) throws SQLException, ServiceException;

    Product getProductbyTruckId(String truckId) throws SQLException, ServiceException;

    Product getProductbyGripId(String gripId) throws SQLException, ServiceException;

    Product getProductbyWheelId(String wheelId) throws SQLException, ServiceException;

    Signature getbyDeckId(String deckId) throws SQLException, ServiceException;

    Signature getbyTruckId(String truckId) throws SQLException, ServiceException;

    Signature getbyGripId(String gripId) throws SQLException, ServiceException;

    Signature getbyWheelId(String wheelId) throws SQLException, ServiceException;

    SignaturesDto replaceIdsWithNames(List<Signature> signatures, UserService userService, ProductsService productsService) throws SQLException, ServiceException;
}
