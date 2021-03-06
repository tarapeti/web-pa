package com.codecool.web.service.simple;

import com.codecool.web.dao.ProductsDao;
import com.codecool.web.model.Product;
import com.codecool.web.service.ProductsService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleProductsService implements ProductsService {
    private final ProductsDao productsDao;


    public SimpleProductsService(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public List<Product> getAll() throws SQLException, SQLException {
        return productsDao.findAll();
    }

    @Override
    public List<Product> getbyName(String name) throws SQLException, SQLException {
        return productsDao.findbyName(name);
    }

    @Override
    public List<Product> getbyBrand(String brand) throws SQLException, SQLException {
        return productsDao.findbyBrand(brand);
    }

    @Override
    public Product getbyId(int prodcutId) throws SQLException, ServiceException {
        try {
            return productsDao.findbyId((prodcutId));
        } catch (NumberFormatException ex) {
            throw new ServiceException("prodcutId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public int countAllProducts() throws SQLException, SQLException {
        return productsDao.countAllProducts();
    }

    @Override
    public Product[] getbyPriceASC() throws SQLException, SQLException {
        return productsDao.findbyPriceASC();
    }

    @Override
    public Product[] getbyPriceDESC() throws SQLException, SQLException {
        return productsDao.findbyPriceDESC();
    }

    @Override
    public List<Product> getProductByTypeId(String type) throws SQLException, ServiceException {
        try {
            return productsDao.findProductByTypeId(Integer.parseInt(type));
        } catch (NumberFormatException ex) {
            throw new ServiceException("typeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void addProduct(String typeId, String name, String brand, String price) throws SQLException, ServiceException {
        try {
            productsDao.addProduct(Integer.parseInt(typeId), name, brand, Integer.parseInt(price));
        } catch (NumberFormatException ex) {
            throw new ServiceException("typeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
