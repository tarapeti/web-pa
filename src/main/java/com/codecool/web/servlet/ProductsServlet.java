package com.codecool.web.servlet;

import com.codecool.web.dao.ProductsDao;
import com.codecool.web.dao.TypesDao;
import com.codecool.web.dao.database.DatabaseProductsDao;
import com.codecool.web.dao.database.DatabaseTypesDao;
import com.codecool.web.dto.ProductsDto;
import com.codecool.web.model.Product;
import com.codecool.web.model.Type;
import com.codecool.web.service.ProductsService;
import com.codecool.web.service.TypesService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleProductsService;
import com.codecool.web.service.simple.SimpleTypesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductsServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);
            List<Product> products;

            String typeId = req.getParameter("typeId"); //nullpointer??

            if (typeId.equals(null)){
                products = productsService.getAll();
            }
            products = productsService.getProductByTypeId(typeId);


        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        }

    }
}
