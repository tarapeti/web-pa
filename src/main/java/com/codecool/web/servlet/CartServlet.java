package com.codecool.web.servlet;

import com.codecool.web.dao.ProductsDao;
import com.codecool.web.dao.database.DatabaseProductsDao;
import com.codecool.web.model.Product;
import com.codecool.web.service.ProductsService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/cart")
public class CartServlet extends AbstractServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {

            String productId = req.getParameter("productId");

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }
}
