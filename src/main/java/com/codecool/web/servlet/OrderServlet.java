package com.codecool.web.servlet;

import com.codecool.web.dao.OrdersDao;
import com.codecool.web.dao.ProductsDao;
import com.codecool.web.dao.database.DatabaseOrdersDao;
import com.codecool.web.dao.database.DatabaseProductsDao;
import com.codecool.web.dto.OrderDto;
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

@WebServlet("/order")
public class OrderServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            OrdersDao ordersDao = new DatabaseOrdersDao(connection);
            OrdersService ordersService = new SimpleOrdersService(ordersDao);

            User user = (User) req.getSession().getAttribute("user");
            int userId = user.getId();

            List<Order> orders = ordersService.getbyCustomerId(userId);
            List<OrderDetail> orderDetails = ordersService.findOrderDetailsForEachOrder(orders);



            sendMessage(resp, HttpServletResponse.SC_OK, new OrderDto(orders, orderDetails));
        } catch (SQLException e) {
            handleSqlError(resp, e);


        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            OrdersDao ordersDao = new DatabaseOrdersDao(connection);
            OrdersService ordersService = new SimpleOrdersService(ordersDao);

            ProductsDao productsDao = new DatabaseProductsDao(connection);
            ProductsService productsService = new SimpleProductsService(productsDao);

            User user = (User) req.getSession().getAttribute("user");
            int userId = user.getId();

            long currentTimeMillis = System.currentTimeMillis();


            String productIds = req.getParameter("productIds");
            String[] prodIds = productIds.split(",");

            for (int i = 0; i < prodIds.length ; i++) {
                int price = productsService.getbyId(Integer.parseInt(prodIds[i])).getPrice();
                ordersService.order(userId, prodIds[i], price, currentTimeMillis);
            }

            sendMessage(resp, HttpServletResponse.SC_OK, null);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
