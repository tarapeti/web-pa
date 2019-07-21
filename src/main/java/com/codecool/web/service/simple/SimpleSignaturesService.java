package com.codecool.web.service.simple;

import com.codecool.web.dao.SignaturesDao;
import com.codecool.web.dto.SignaturesDto;
import com.codecool.web.model.Product;
import com.codecool.web.model.Signature;
import com.codecool.web.service.ProductsService;
import com.codecool.web.service.SignaturesService;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleSignaturesService implements SignaturesService {
    private final SignaturesDao signaturesDao;

    public SimpleSignaturesService(SignaturesDao signaturesDao) {
        this.signaturesDao = signaturesDao;
    }

    @Override
    public List<Signature> getAll() throws SQLException {
        return signaturesDao.findAll();
    }

    @Override
    public Signature getbyProId(String proId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findbyProId(Integer.parseInt(proId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("proId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Product getProductbyDeckId(String deckId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findProductbyDeckId(Integer.parseInt(deckId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("deckId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Product getProductbyTruckId(String truckId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findProductbyTruckId(Integer.parseInt(truckId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("truckId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Product getProductbyGripId(String gripId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findProductbyGripId(Integer.parseInt(gripId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("gripId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Product getProductbyWheelId(String wheelId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findProductbyWheelId(Integer.parseInt(wheelId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("wheelId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Signature getbyDeckId(String deckId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findbyDeckId(Integer.parseInt(deckId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("deckId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Signature getbyTruckId(String truckId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findbyTruckId(Integer.parseInt(truckId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("truckId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Signature getbyGripId(String gripId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findbyGripId(Integer.parseInt(gripId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("gripId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Signature getbyWheelId(String wheelId) throws SQLException, ServiceException {
        try {
            return signaturesDao.findbyWheelId(Integer.parseInt(wheelId));
        }  catch (NumberFormatException ex) {
            throw new ServiceException("wheelId must be an integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public SignaturesDto replaceIdsWithNames(List<Signature> signatures, UserService userService, ProductsService productsService) throws SQLException, ServiceException {
        List<List<String>> all = new ArrayList<>();
        for (Signature signature : signatures) {
            List<String> names = new ArrayList<>();
            names.add(productsService.getbyId(signature.getDeckId()).getName());
            names.add(productsService.getbyId(signature.getGripId()).getName());
            names.add(productsService.getbyId(signature.getTruckId()).getName());
            names.add(productsService.getbyId(signature.getWheelId()).getName());
            names.add(userService.getbyId( signature.getProId()).getUsername());
            all.add(names);
        }
        return new SignaturesDto(all);
    }
}
