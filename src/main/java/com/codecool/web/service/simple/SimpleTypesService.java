package com.codecool.web.service.simple;

import com.codecool.web.dao.TypesDao;
import com.codecool.web.model.Type;
import com.codecool.web.service.TypesService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleTypesService implements TypesService {
    private final TypesDao typesDao;

    public SimpleTypesService(TypesDao typesDao) {
        this.typesDao = typesDao;
    }

    @Override
    public List<Type> getAll() throws SQLException {
        return typesDao.findAll();
    }

    @Override
    public Type getbyId(String typeId) throws SQLException, ServiceException {
        try {
            return typesDao.findbyId(Integer.parseInt(typeId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("typeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<Type> getbyName(String name) throws SQLException {
            return typesDao.findbyName(name);
    }

    @Override
    public Type getProductbyType(String prodId) throws SQLException, ServiceException {
        try {
            return typesDao.findTypebyProductId(Integer.parseInt(prodId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("prodId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
