package com.laba.solvd.db.service;

import com.laba.solvd.db.Interfaces.CredentialsRepository;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Credential;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CredentialsServiceImpl implements CredentialsRepository {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Credential credential) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Credentials(id, login, password) VALUES (?, ?, ?)");
            preparedStatement.setLong(1, credential.getId());
            preparedStatement.setString(2, credential.getLogin());
            preparedStatement.setString(3, credential.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create credentials", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Credential> findById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Credentials WHERE id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long foundId = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                Credential credential = new Credential(foundId, login, password);
                return Optional.of(credential);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to find credentials by ID", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return Optional.empty();
    }

    @Override
    public List<Credential> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Credentials");

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Credential> credentialList = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                Credential credential = new Credential(id, login, password);
                credentialList.add(credential);
            }

            return credentialList;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to fetch all credentials", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Credential credential) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Credentials SET login = ?, password = ? WHERE id = ?");
            preparedStatement.setString(1, credential.getLogin());
            preparedStatement.setString(2, credential.getPassword());
            preparedStatement.setLong(3, credential.getId());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new RuntimeException("Failed to update credentials. No matching record found for ID: " + credential.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to update credentials", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Credentials WHERE id = ?");
            preparedStatement.setLong(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted == 0) {
                throw new RuntimeException("Failed to delete credentials. No matching record found for ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to delete credentials", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}

