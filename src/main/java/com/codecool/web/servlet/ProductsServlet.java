package com.codecool.web.servlet;

import com.codecool.web.dao.ProductsDao;
import com.codecool.web.dao.database.DatabaseProductsDao;
import com.codecool.web.service.ProductsService;
import com.codecool.web.service.simple.SimpleProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/product")
public class ProductsServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);

            String productType = req.getParameter("type");

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }

    }
}
