package com.codecool.web.servlet;

import com.codecool.web.dao.ProductsDao;
import com.codecool.web.dao.SignaturesDao;
import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.database.DatabaseProductsDao;
import com.codecool.web.dao.database.DatabaseSignaturesDao;
import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.dto.SignaturesDto;
import com.codecool.web.model.Signature;
import com.codecool.web.service.ProductsService;
import com.codecool.web.service.SignaturesService;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleProductsService;
import com.codecool.web.service.simple.SimpleSignaturesService;
import com.codecool.web.service.simple.SimpleUsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/signature")
public class SignaturesServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            SignaturesDao signaturesDao = new DatabaseSignaturesDao(connection);
            SignaturesService signaturesService = new SimpleSignaturesService(signaturesDao);

            UserDao userDao = new DatabaseUserDao(connection);
            UserService userService = new SimpleUsersService(userDao);

            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);

            List<Signature> signatures = signaturesService.getAll();

            SignaturesDto signaturesDto = signaturesService.replaceIdsWithNames(signatures, userService, productsService);


            sendMessage(resp, HttpServletResponse.SC_OK, signaturesDto);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            e.printStackTrace();
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
