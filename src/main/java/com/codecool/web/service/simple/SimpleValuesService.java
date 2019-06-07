package com.codecool.web.service.simple;

import com.codecool.web.dao.ValuesDao;
import com.codecool.web.model.Value;
import com.codecool.web.service.ValueService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleValuesService implements ValueService {
    private final ValuesDao valuesDao;

    public SimpleValuesService(ValuesDao valuesDao) {
        this.valuesDao = valuesDao;
    }

    @Override
    public List<Value> getAll() throws SQLException {
        return valuesDao.findAll();
    }

    @Override
    public Value getbyAttributeId(String attributeId) throws SQLException, ServiceException {
        try {
            return valuesDao.findbyAttributeId(Integer.parseInt(attributeId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("attributeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Value getbyProductId(String productId) throws SQLException, ServiceException {
        try {
            return valuesDao.findbyProductId(Integer.parseInt(productId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("productId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public String stringValuebyAttibuteId(String attributeId) throws SQLException, ServiceException {
        try {
            return valuesDao.stringValuebyAttibuteId(Integer.parseInt(attributeId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("atrributeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public int intValuebyAttributeId(String attributeId) throws SQLException, ServiceException {
        try {
            return valuesDao.intValuebyAttributeId(Integer.parseInt(attributeId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("attributeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public boolean booleanValuebyAttributeId(String attributeId) throws SQLException, ServiceException {
        try {
            return valuesDao.booleanValuebyAttributeId(Integer.parseInt(attributeId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("attributeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }    }
}
