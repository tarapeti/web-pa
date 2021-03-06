package com.codecool.web.servlet;

import com.codecool.web.dao.ProductsDao;
import com.codecool.web.dao.database.DatabaseProductsDao;
import com.codecool.web.dto.ProductsDto;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);

            String productIds = req.getParameter("productIds");
            String[] prodIds = productIds.split(",");

            if (productIds.equals("")) {
                sendMessage(resp, 200, null);

            } else {
                List<Product> porductsInCart = new ArrayList<>();
                for (int i = 0; i < prodIds.length; i++) {
                    porductsInCart.add(productsService.getbyId(Integer.parseInt(prodIds[i])));
                }
                sendMessage(resp, HttpServletResponse.SC_OK, new ProductsDto(porductsInCart));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}