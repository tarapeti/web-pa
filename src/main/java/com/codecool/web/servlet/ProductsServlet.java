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
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);
            List<Product> products;

            String typeId = req.getParameter("typeId");

            if (typeId.equals("all")) {
                products = productsService.getAll();
            } else {
                products = productsService.getProductByTypeId(typeId);
            }

            sendMessage(resp, HttpServletResponse.SC_OK, new ProductsDto(products));
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
            Product[] products;

            String ordering = req.getParameter("ordering");

            if (ordering.equals("asc")){
                products = productsService.getbyPriceASC();
            } else {
                products = productsService.getbyPriceDESC();
            }

            sendMessage(resp, HttpServletResponse.SC_OK, products);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }
}
