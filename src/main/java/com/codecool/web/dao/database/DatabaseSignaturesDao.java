package com.codecool.web.dao.database;

import com.codecool.web.dao.SignaturesDao;
import com.codecool.web.model.Product;
import com.codecool.web.model.Signature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSignaturesDao extends AbstractDao implements SignaturesDao {
    DatabaseSignaturesDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Signature> findAll() throws SQLException {
        String sql = "SELECT * FROM signatures";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Signature> signatures = new ArrayList<>();
            while (resultSet.next()) {
                signatures.add(fetchSignature(resultSet));
            }
            return signatures;
        }
    }

    @Override
    public Signature findbyProId(int proId) throws SQLException {
        String sql = "SELECT * FROM signatures where pro_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, proId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchSignature(resultSet);
                }
            }
        }
        return null;
    }



    @Override
    public Signature findbyDeckId(int deckId) throws SQLException {
        String sql = "SELECT * FROM signatures where deck_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, deckId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchSignature(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Signature findbyTruckId(int truckId) throws SQLException {
        String sql = "SELECT * FROM signatures where truck_id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, truckId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchSignature(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Signature findbyGripId(int gripId) throws SQLException {
        String sql = "SELECT * FROM signatures where grip_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, gripId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchSignature(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Signature findbyWheelId(int wheelId) throws SQLException {
        String sql = "SELECT * FROM signatures where wheel_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wheelId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchSignature(resultSet);
                }
            }
        }
        return null;
    }


    @Override
    public Product findProductbyDeckId(int deckId) throws SQLException {
        String sql = "SELECT * FROM products inner join signatures s on products.id = s.deck_id where deck_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, deckId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchProduct(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Product findProductbyTruckId(int truckId) throws SQLException {
        String sql = "SELECT * FROM products inner join signatures s on products.id = s.truck_id where truck_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, truckId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchProduct(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Product findProductbyGripId(int gripId) throws SQLException {
        String sql = "SELECT * FROM products inner join signatures s on products.id = s.grip_id where grip_id= ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, gripId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchProduct(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Product findProductbyWheelId(int wheelId) throws SQLException {
        String sql = "SELECT * FROM products inner join signatures s on products.id = s.wheel_id where wheel_id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wheelId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchProduct(resultSet);
                }
            }
        }
        return null;
    }

    private Signature fetchSignature(ResultSet resultSet) throws SQLException {
        int proId = resultSet.getInt("pro_id");
        int deckId = resultSet.getInt("deck_id");
        int gripId = resultSet.getInt("grip_id");
        int truckId = resultSet.getInt("truck_id");
        int wheelId = resultSet.getInt("wheel_id");
        return new Signature(proId, deckId, gripId, truckId, wheelId);
    }

    private Product fetchProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int typeId = resultSet.getInt("type_id");
        String name = resultSet.getString("name");
        String brand = resultSet.getString("brand");
        int price = resultSet.getInt("price");
        return new Product(id, typeId, name, brand, price);
    }
}
