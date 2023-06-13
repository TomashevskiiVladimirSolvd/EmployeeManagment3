package com.laba.solvd.db.dao;

import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.dao.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CredentialDAO implements IDao<Credential, Long> {
    private Connection connection;

    public CredentialDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Credential entity) {
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
    public Credential read(Long id) {
        Credential credential = null;
        try {
            String sql = "SELECT * FROM Credentials WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                credential = new Credential();
                credential.setId(resultSet.getLong("id"));
                credential.setLogin(resultSet.getString("login"));
                credential.setPassword(resultSet.getString("password"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credential;
    }

    @Override
    public void update(Credential entity) {
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
    public List<Credential> getAll() {
        List<Credential> credentialList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Credentials";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Credential credential = new Credential();
                credential.setId(resultSet.getLong("id"));
                credential.setLogin(resultSet.getString("login"));
                credential.setPassword(resultSet.getString("password"));
                credentialList.add(credential);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentialList;
    }

}

