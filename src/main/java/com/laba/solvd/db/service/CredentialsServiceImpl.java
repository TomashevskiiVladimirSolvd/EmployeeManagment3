package com.laba.solvd.db.service;

import com.laba.solvd.db.Interfaces.CredentialsRepositoty;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Credentials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CredentialsServiceImpl implements CredentialsRepositoty {
    private static final ConnectionPool CONNECTION_POOL =ConnectionPool.getInstance();

    @Override
    public void create(Credentials credentials) {
        Connection connection= CONNECTION_POOL.getConnection();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("Insert into Credentials(id,login,password)values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,credentials.getId());
            preparedStatement.setString(2,credentials.getLogin());
            preparedStatement.setString(3,credentials.getPassword());

            preparedStatement.executeUpdate();
            ResultSet resultSet= preparedStatement.getGeneratedKeys();
        }catch(SQLException e){
           throw new RuntimeException("Unable to create credentials",e);
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
            }
        }



    @Override
    public Optional<Credentials> findById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Credentials WHERE id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long foundId = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                Credentials credentials = new Credentials(foundId, login, password);
                return Optional.of(credentials);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to find credentials by ID", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return Optional.empty();
    }


    @Override
    public List<Credentials> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Credentials");

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Credentials> credentialsList = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                Credentials credentials = new Credentials(id, login, password);
                credentialsList.add(credentials);
            }

            return credentialsList;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to fetch all credentials", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }


    @Override
    public void update(Credentials credentials) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Credentials SET login = ?, password = ? WHERE id = ?");
            preparedStatement.setString(1, credentials.getLogin());
            preparedStatement.setString(2, credentials.getPassword());
            preparedStatement.setLong(3, credentials.getId());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new RuntimeException("Failed to update credentials. No matching record found for ID: " + credentials.getId());
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
