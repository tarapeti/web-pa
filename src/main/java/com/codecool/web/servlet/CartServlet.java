package com.codecool.web.servlet;

import com.codecool.web.dao.OrdersDao;
import com.codecool.web.dao.ProductsDao;
import com.codecool.web.dao.database.DatabaseOrdersDao;
import com.codecool.web.dao.database.DatabaseProductsDao;
import com.codecool.web.dto.OrderDto;
import com.codecool.web.dto.ProductsDto;
import com.codecool.web.model.Order;
import com.codecool.web.model.OrderDetail;
import com.codecool.web.model.Product;
import com.codecool.web.model.User;
import com.codecool.web.service.OrdersService;
import com.codecool.web.service.ProductsService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleOrdersService;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);

            String productIds = req.getParameter("productIds");
            String[] prodIds = productIds.split(",");

            List<Product> porductsInCart = new ArrayList<>();
            for (int i = 0; i < prodIds.length ; i++) {
                porductsInCart.add(productsService.getbyId(Integer.parseInt(prodIds[i])));

            }

            sendMessage(resp, HttpServletResponse.SC_OK, new ProductsDto(porductsInCart));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

//kellene elotte a cart és utána megrendelni??
//nem serial orderid

//VAGY átneezni cart és cartdetailre és az order nem csinálna igazábol semmit
//productdetail popupba kéne navigáció egyszerűsítés miatt

