package com.codecool.web.service.simple;

import com.codecool.web.dao.AttriburesDao;
import com.codecool.web.model.Attribure;
import com.codecool.web.service.AttributesService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleAttributesService implements AttributesService {
    private final AttriburesDao attriburesDao;

    public SimpleAttributesService(AttriburesDao attriburesDao) {
        this.attriburesDao = attriburesDao;
    }

    @Override
    public List<Attribure> getAll() throws SQLException, ServiceException {
        return attriburesDao.findAll();
    }

    @Override
    public Attribure getbyId(String attributeId) throws SQLException, ServiceException {
        try {
            return attriburesDao.findbyId(Integer.parseInt(attributeId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("attributeId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<Attribure> getbyType(String type) throws SQLException, ServiceException {
        return attriburesDao.findbyType(type);
    }
}
