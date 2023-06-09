package com.laba.solvd.db.dao;

import com.laba.solvd.db.domain.Credentials;
import com.laba.solvd.db.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CredentialsDAO implements IDao<Credentials, Long> {
    private Connection connection;

    public CredentialsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Credentials entity) {
        try {
            String sql = "INSERT INTO Credentials (id, login, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getLogin());
            statement.setString(3, entity.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Credentials read(Long id) {
        Credentials credentials = null;
        try {
            String sql = "SELECT * FROM Credentials WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                credentials = new Credentials();
                credentials.setId(resultSet.getLong("id"));
                credentials.setLogin(resultSet.getString("login"));
                credentials.setPassword(resultSet.getString("password"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    @Override
    public void update(Credentials entity) {
        try {
            String sql = "UPDATE Credentials SET login = ?, password = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setLong(3, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Credentials WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Credentials> getAll() {
        List<Credentials> credentialsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Credentials";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Credentials credentials = new Credentials();
                credentials.setId(resultSet.getLong("id"));
                credentials.setLogin(resultSet.getString("login"));
                credentials.setPassword(resultSet.getString("password"));
                credentialsList.add(credentials);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentialsList;
    }

}

