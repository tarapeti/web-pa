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

@WebServlet("/product")
public class ProductServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);

            String productId = req.getParameter("productId");

            Product product = productsService.getbyId(Integer.parseInt(productId));

            sendMessage(resp, HttpServletResponse.SC_OK, product);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);

            String name = req.getParameter("name");
            String type = req.getParameter("type");
            String brand = req.getParameter("brand");
            String price = req.getParameter("price");

            productsService.addProduct(type, name, brand, price);

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
